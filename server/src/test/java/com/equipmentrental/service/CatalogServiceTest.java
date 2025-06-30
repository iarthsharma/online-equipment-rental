import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.equipmentrental.model.Equipment;
import com.equipmentrental.repository.EquipmentRepository;
import com.equipmentrental.service.impl.CatalogServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class CatalogServiceTest {

    @InjectMocks
    private CatalogServiceImpl catalogService;

    @Mock
    private EquipmentRepository equipmentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEquipment() {
        Equipment equipment1 = new Equipment("1", "Drill", "Power drill", 10);
        Equipment equipment2 = new Equipment("2", "Saw", "Circular saw", 5);
        List<Equipment> equipmentList = Arrays.asList(equipment1, equipment2);

        when(equipmentRepository.findAll()).thenReturn(equipmentList);

        List<Equipment> result = catalogService.getAllEquipment();

        assertEquals(2, result.size());
        verify(equipmentRepository, times(1)).findAll();
    }

    @Test
    void testGetEquipmentById() {
        Equipment equipment = new Equipment("1", "Drill", "Power drill", 10);
        when(equipmentRepository.findById("1")).thenReturn(Optional.of(equipment));

        Optional<Equipment> result = catalogService.getEquipmentById("1");

        assertTrue(result.isPresent());
        assertEquals("Drill", result.get().getName());
        verify(equipmentRepository, times(1)).findById("1");
    }

    @Test
    void testGetEquipmentById_NotFound() {
        when(equipmentRepository.findById("1")).thenReturn(Optional.empty());

        Optional<Equipment> result = catalogService.getEquipmentById("1");

        assertFalse(result.isPresent());
        verify(equipmentRepository, times(1)).findById("1");
    }
}