package com.equipmentrental.repository;

import com.equipmentrental.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {
    List<Booking> findByUserId(String userId);
    List<Booking> findByEquipmentId(String equipmentId);
    List<Booking> findByStatus(String status);
}