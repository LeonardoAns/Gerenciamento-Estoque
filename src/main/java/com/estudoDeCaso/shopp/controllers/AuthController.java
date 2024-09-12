package com.estudoDeCaso.shopp.controllers;

import com.estudoDeCaso.shopp.dto.auth.AuthRequestDto;
import com.estudoDeCaso.shopp.dto.auth.AuthResponseDto;
import com.estudoDeCaso.shopp.entities.Employee;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.EmployeeRepository;
import com.estudoDeCaso.shopp.useCases.jwt.GenerateTokenUseCase;
import com.estudoDeCaso.shopp.useCases.jwt.ValidateTokenUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final GenerateTokenUseCase generateTokenUseCase;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDto authRequestDto) {
        Employee employee = this.employeeRepository.findEmployeeByEmail(authRequestDto.getEmail())
                .orElseThrow(() -> new NotFoundException("Employee not found"));

        if (passwordEncoder.matches(authRequestDto.getPassword(), employee.getPassword())) {
            String token = this.generateTokenUseCase.generateToken(employee);
            AuthResponseDto response = new AuthResponseDto(token);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body("Invalid credentials");
    }



}
