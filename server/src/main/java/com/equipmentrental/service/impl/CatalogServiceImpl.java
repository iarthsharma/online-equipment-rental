package com.equipmentrental.service.impl;

import com.equipmentrental.dto.EquipmentDto;
import com.equipmentrental.model.Equipment;
import com.equipmentrental.repository.EquipmentRepository;
import com.equipmentrental.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final EquipmentRepository equipmentRepository;

    @Autowired
    public CatalogServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public List<EquipmentDto> getAllEquipment() {
        List<Equipment> equipmentList = equipmentRepository.findAll();
        return equipmentList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public EquipmentDto getEquipmentById(String id) {
        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Equipment not found with id: " + id));
        return convertToDto(equipment);
    }

    private EquipmentDto convertToDto(Equipment equipment) {
        EquipmentDto dto = new EquipmentDto();
        dto.setId(equipment.getId());
        dto.setName(equipment.getName());
        dto.setDescription(equipment.getDescription());
        dto.setAvailability(equipment.isAvailable());
        return dto;
    }
}