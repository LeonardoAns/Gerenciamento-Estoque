package com.estudoDeCaso.shopp.controllers.employee;

import com.estudoDeCaso.shopp.dto.employee.EmployeeRequestDto;
import com.estudoDeCaso.shopp.useCases.employee.CreateEmployeeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class CreateEmployeeController {

    private final CreateEmployeeUseCase createEmployeeUseCase;

    @PostMapping
    public ResponseEntity<URI> createEmployee(@RequestBody EmployeeRequestDto employeeRequestDto){
        Long employeeId = this.createEmployeeUseCase.execute(employeeRequestDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(employeeId)
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
