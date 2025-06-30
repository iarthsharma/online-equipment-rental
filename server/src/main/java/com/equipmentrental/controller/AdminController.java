package com.equipmentrental.controller;

import com.equipmentrental.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Example endpoint for getting admin details
    @GetMapping("/details")
    public ResponseEntity<?> getAdminDetails() {
        // Logic to retrieve admin details
        return ResponseEntity.ok(adminService.getAdminDetails());
    }

    // Example endpoint for updating admin settings
    @PutMapping("/settings")
    public ResponseEntity<?> updateAdminSettings(@RequestBody Object settings) {
        // Logic to update admin settings
        adminService.updateAdminSettings(settings);
        return ResponseEntity.ok("Settings updated successfully");
    }

    // Additional admin-related endpoints can be added here
}