package com.equipmentrental.repository;

import com.equipmentrental.model.Equipment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends MongoRepository<Equipment, String> {
    List<Equipment> findByAvailable(boolean available);
    Equipment findById(String id);
}