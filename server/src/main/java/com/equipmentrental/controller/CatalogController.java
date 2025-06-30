package com.equipmentrental.controller;

import com.equipmentrental.dto.EquipmentDto;
import com.equipmentrental.dto.EquipmentAvailabilityDto;
import com.equipmentrental.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/equipment")
    public ResponseEntity<List<EquipmentDto>> getAllEquipment() {
        List<EquipmentDto> equipmentList = catalogService.getAllEquipment();
        return ResponseEntity.ok(equipmentList);
    }

    @GetMapping("/equipment/{id}")
    public ResponseEntity<EquipmentDto> getEquipmentById(@PathVariable String id) {
        EquipmentDto equipment = catalogService.getEquipmentById(id);
        return ResponseEntity.ok(equipment);
    }

    @PostMapping("/equipment")
    public ResponseEntity<EquipmentDto> addEquipment(@RequestBody EquipmentDto equipmentDto) {
        EquipmentDto createdEquipment = catalogService.addEquipment(equipmentDto);
        return ResponseEntity.status(201).body(createdEquipment);
    }

    @PutMapping("/equipment/{id}")
    public ResponseEntity<EquipmentDto> updateEquipment(@PathVariable String id, @RequestBody EquipmentDto equipmentDto) {
        EquipmentDto updatedEquipment = catalogService.updateEquipment(id, equipmentDto);
        return ResponseEntity.ok(updatedEquipment);
    }

    @DeleteMapping("/equipment/{id}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable String id) {
        catalogService.deleteEquipment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/availability")
    public ResponseEntity<List<EquipmentAvailabilityDto>> getEquipmentAvailability() {
        List<EquipmentAvailabilityDto> availabilityList = catalogService.getEquipmentAvailability();
        return ResponseEntity.ok(availabilityList);
    }
}