import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.equipmentrental.controller.CatalogController;
import com.equipmentrental.service.CatalogService;
import com.equipmentrental.model.Equipment;
import com.equipmentrental.dto.EquipmentDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.Optional;

public class CatalogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CatalogService catalogService;

    @InjectMocks
    private CatalogController catalogController;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(catalogController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testGetAllEquipment() throws Exception {
        Equipment equipment = new Equipment();
        equipment.setId("1");
        equipment.setName("Excavator");

        when(catalogService.getAllEquipment()).thenReturn(Collections.singletonList(equipment));

        mockMvc.perform(get("/api/equipment")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Excavator"));
    }

    @Test
    public void testGetEquipmentById() throws Exception {
        Equipment equipment = new Equipment();
        equipment.setId("1");
        equipment.setName("Excavator");

        when(catalogService.getEquipmentById("1")).thenReturn(Optional.of(equipment));

        mockMvc.perform(get("/api/equipment/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Excavator"));
    }

    @Test
    public void testGetEquipmentById_NotFound() throws Exception {
        when(catalogService.getEquipmentById("2")).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/equipment/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCreateEquipment() throws Exception {
        EquipmentDto equipmentDto = new EquipmentDto();
        equipmentDto.setName("Excavator");

        when(catalogService.createEquipment(any(EquipmentDto.class))).thenReturn(equipmentDto);

        mockMvc.perform(post("/api/equipment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(equipmentDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Excavator"));
    }
}