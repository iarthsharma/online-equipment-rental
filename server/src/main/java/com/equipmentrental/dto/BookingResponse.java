package com.equipmentrental.dto;

import java.time.LocalDateTime;

public class BookingResponse {
    private String bookingId;
    private String equipmentId;
    private String userId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;

    public BookingResponse(String bookingId, String equipmentId, String userId, LocalDateTime startTime, LocalDateTime endTime, String status) {
        this.bookingId = bookingId;
        this.equipmentId = equipmentId;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}