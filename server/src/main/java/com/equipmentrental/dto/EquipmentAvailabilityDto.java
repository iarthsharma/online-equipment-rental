package com.equipmentrental.dto;

import java.time.LocalDateTime;

public class EquipmentAvailabilityDto {
    private String equipmentId;
    private boolean available;
    private LocalDateTime availableFrom;
    private LocalDateTime availableUntil;

    public EquipmentAvailabilityDto() {
    }

    public EquipmentAvailabilityDto(String equipmentId, boolean available, LocalDateTime availableFrom, LocalDateTime availableUntil) {
        this.equipmentId = equipmentId;
        this.available = available;
        this.availableFrom = availableFrom;
        this.availableUntil = availableUntil;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public LocalDateTime getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(LocalDateTime availableFrom) {
        this.availableFrom = availableFrom;
    }

    public LocalDateTime getAvailableUntil() {
        return availableUntil;
    }

    public void setAvailableUntil(LocalDateTime availableUntil) {
        this.availableUntil = availableUntil;
    }
}