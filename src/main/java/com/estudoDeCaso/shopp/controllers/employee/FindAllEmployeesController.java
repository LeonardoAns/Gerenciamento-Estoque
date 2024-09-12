package com.estudoDeCaso.shopp.controllers.employee;

import com.estudoDeCaso.shopp.dto.employee.EmployeeResponseDto;
import com.estudoDeCaso.shopp.useCases.employee.FindAllEmployeesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class FindAllEmployeesController {

    private final FindAllEmployeesUseCase findAllEmployeesUseCase;

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> findAllEmplyees(){
        List<EmployeeResponseDto> employeeResponseDtos = this.findAllEmployeesUseCase.execute();
        return ResponseEntity.ok(employeeResponseDtos);
    }
}
