import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.equipmentrental.model.Booking;
import com.equipmentrental.repository.BookingRepository;
import com.equipmentrental.service.impl.BookingServiceImpl;

import java.util.Optional;

class BookingServiceTest {

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Mock
    private BookingRepository bookingRepository;

    private Booking booking;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        booking = new Booking();
        booking.setId("1");
        booking.setEquipmentId("equipment1");
        booking.setUserId("user1");
    }

    @Test
    void testCreateBooking() {
        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);
        Booking createdBooking = bookingService.createBooking(booking);
        assertNotNull(createdBooking);
        assertEquals("1", createdBooking.getId());
    }

    @Test
    void testGetBookingById() {
        when(bookingRepository.findById("1")).thenReturn(Optional.of(booking));
        Booking foundBooking = bookingService.getBookingById("1");
        assertNotNull(foundBooking);
        assertEquals("1", foundBooking.getId());
    }

    @Test
    void testGetBookingById_NotFound() {
        when(bookingRepository.findById("2")).thenReturn(Optional.empty());
        Booking foundBooking = bookingService.getBookingById("2");
        assertNull(foundBooking);
    }

    @Test
    void testDeleteBooking() {
        doNothing().when(bookingRepository).deleteById("1");
        bookingService.deleteBooking("1");
        verify(bookingRepository, times(1)).deleteById("1");
    }
}