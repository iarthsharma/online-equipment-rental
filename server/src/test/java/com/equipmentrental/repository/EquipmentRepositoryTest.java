import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.equipmentrental.model.Equipment;
import com.equipmentrental.repository.EquipmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class EquipmentRepositoryTest {

    @Mock
    private EquipmentRepository equipmentRepository;

    @InjectMocks
    private EquipmentRepositoryTest equipmentRepositoryTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Equipment equipment1 = new Equipment();
        equipment1.setId("1");
        equipment1.setName("Excavator");

        Equipment equipment2 = new Equipment();
        equipment2.setId("2");
        equipment2.setName("Bulldozer");

        when(equipmentRepository.findAll()).thenReturn(Arrays.asList(equipment1, equipment2));

        List<Equipment> equipmentList = equipmentRepository.findAll();
        assertEquals(2, equipmentList.size());
        verify(equipmentRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        Equipment equipment = new Equipment();
        equipment.setId("1");
        equipment.setName("Excavator");

        when(equipmentRepository.findById("1")).thenReturn(Optional.of(equipment));

        Optional<Equipment> foundEquipment = equipmentRepository.findById("1");
        assertTrue(foundEquipment.isPresent());
        assertEquals("Excavator", foundEquipment.get().getName());
        verify(equipmentRepository, times(1)).findById("1");
    }

    @Test
    void testSave() {
        Equipment equipment = new Equipment();
        equipment.setId("1");
        equipment.setName("Excavator");

        when(equipmentRepository.save(equipment)).thenReturn(equipment);

        Equipment savedEquipment = equipmentRepository.save(equipment);
        assertNotNull(savedEquipment);
        assertEquals("Excavator", savedEquipment.getName());
        verify(equipmentRepository, times(1)).save(equipment);
    }

    @Test
    void testDelete() {
        Equipment equipment = new Equipment();
        equipment.setId("1");
        equipment.setName("Excavator");

        doNothing().when(equipmentRepository).delete(equipment);

        equipmentRepository.delete(equipment);
        verify(equipmentRepository, times(1)).delete(equipment);
    }
}