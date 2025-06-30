package com.equipmentrental.service.impl;

import com.equipmentrental.dto.BookingRequest;
import com.equipmentrental.dto.BookingResponse;
import com.equipmentrental.exception.ConflictException;
import com.equipmentrental.exception.EntityNotFoundException;
import com.equipmentrental.model.Booking;
import com.equipmentrental.repository.BookingRepository;
import com.equipmentrental.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingResponse createBooking(BookingRequest bookingRequest) {
        // Logic to create a booking
        Booking booking = new Booking();
        // Set booking properties from bookingRequest
        // Check for conflicts
        if (isConflict(booking)) {
            throw new ConflictException("Booking conflict detected.");
        }
        Booking savedBooking = bookingRepository.save(booking);
        return new BookingResponse(savedBooking);
    }

    @Override
    public BookingResponse getBookingById(String id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isPresent()) {
            return new BookingResponse(booking.get());
        } else {
            throw new EntityNotFoundException("Booking not found with id: " + id);
        }
    }

    @Override
    public List<BookingResponse> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return BookingResponse.fromBookingList(bookings);
    }

    private boolean isConflict(Booking booking) {
        // Implement conflict checking logic
        return false;
    }
}