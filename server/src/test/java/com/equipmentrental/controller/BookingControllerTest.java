import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.equipmentrental.controller.BookingController;
import com.equipmentrental.dto.BookingRequest;
import com.equipmentrental.dto.BookingResponse;
import com.equipmentrental.service.impl.BookingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class BookingControllerTest {

    @InjectMocks
    private BookingController bookingController;

    @Mock
    private BookingServiceImpl bookingService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookingController).build();
    }

    @Test
    public void testCreateBooking() throws Exception {
        BookingRequest bookingRequest = new BookingRequest();
        // Set properties for bookingRequest as needed

        BookingResponse bookingResponse = new BookingResponse();
        // Set properties for bookingResponse as needed

        when(bookingService.createBooking(any(BookingRequest.class))).thenReturn(bookingResponse);

        mockMvc.perform(post("/api/bookings")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ /* JSON representation of bookingRequest */ }"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.propertyName").value("expectedValue")); // Adjust based on actual response
    }

    @Test
    public void testGetBooking() throws Exception {
        Long bookingId = 1L;
        BookingResponse bookingResponse = new BookingResponse();
        // Set properties for bookingResponse as needed

        when(bookingService.getBooking(bookingId)).thenReturn(bookingResponse);

        mockMvc.perform(get("/api/bookings/{id}", bookingId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.propertyName").value("expectedValue")); // Adjust based on actual response
    }

    // Additional tests for other endpoints can be added here
}