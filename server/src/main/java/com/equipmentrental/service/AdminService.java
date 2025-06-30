package com.equipmentrental.service;

public interface AdminService {
    // Define methods for admin-related operations
    void createAdmin(String username, String password);
    void deleteAdmin(String adminId);
    void updateAdmin(String adminId, String username, String password);
    List<Admin> getAllAdmins();
}