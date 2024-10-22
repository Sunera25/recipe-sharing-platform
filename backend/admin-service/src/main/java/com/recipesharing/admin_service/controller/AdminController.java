package com.recipesharing.admin_service.controller;

import com.recipesharing.admin_service.dto.AdminDTO;
import com.recipesharing.admin_service.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> authenticateAdmin(@Valid @RequestBody AdminDTO adminDTO) {
        return adminService.authenticateAdmin(adminDTO);
    }


}
