package com.equipmentrental.service;

public interface PaymentService {
    void processPayment(String paymentDetails);
    boolean validatePayment(String paymentId);
    String refundPayment(String paymentId);
}