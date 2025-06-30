import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.equipmentrental.model.Booking;
import com.equipmentrental.repository.BookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class BookingRepositoryTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    private Booking booking;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        booking = new Booking();
        booking.setId("1");
        booking.setUserId("user1");
        booking.setEquipmentId("equipment1");
        booking.setStartDate("2023-01-01");
        booking.setEndDate("2023-01-02");
    }

    @Test
    void testFindById() {
        when(bookingRepository.findById("1")).thenReturn(Optional.of(booking));

        Optional<Booking> foundBooking = bookingService.findById("1");

        assertTrue(foundBooking.isPresent());
        assertEquals("1", foundBooking.get().getId());
    }

    @Test
    void testSaveBooking() {
        when(bookingRepository.save(booking)).thenReturn(booking);

        Booking savedBooking = bookingService.save(booking);

        assertNotNull(savedBooking);
        assertEquals("1", savedBooking.getId());
    }

    @Test
    void testDeleteBooking() {
        doNothing().when(bookingRepository).deleteById("1");

        bookingService.delete("1");

        verify(bookingRepository, times(1)).deleteById("1");
    }
}