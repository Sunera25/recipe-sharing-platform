package com.recipesharing.admin_service.service;

import com.recipesharing.admin_service.dto.AdminDTO;
import com.recipesharing.admin_service.exception.WrongPasswordException;
import com.recipesharing.admin_service.model.Admin;
import com.recipesharing.admin_service.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final static Logger logger = LoggerFactory.getLogger(AdminService.class);
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    //login access give if password correct
    public ResponseEntity<Void> authenticateAdmin(AdminDTO adminDTO) {

        String enteredPW = passwordEncoder.encode(adminDTO.getPassword());
        Admin admin = adminRepository.findByAdminName(adminDTO.getName());
        String password = admin.getAdminPassword();

        if (!password.equals(enteredPW)) {
            logger.error("Password does not match");
            throw new WrongPasswordException("Password does not match");
        }
        return ResponseEntity.ok().build();

    }
}
