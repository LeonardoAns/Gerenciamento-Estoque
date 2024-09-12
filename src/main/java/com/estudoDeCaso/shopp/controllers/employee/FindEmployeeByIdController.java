package com.estudoDeCaso.shopp.controllers.employee;

import com.estudoDeCaso.shopp.dto.employee.EmployeeResponseDto;
import com.estudoDeCaso.shopp.useCases.employee.FindEmployeeByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class FindEmployeeByIdController {

    private final FindEmployeeByIdUseCase findEmployeeByIdUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> findEmployeeById(@PathVariable Long id){
        EmployeeResponseDto employeeResponseDto = this.findEmployeeByIdUseCase.execute(id);
        return ResponseEntity.ok().body(employeeResponseDto);
    }
}
