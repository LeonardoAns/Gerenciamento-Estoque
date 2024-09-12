package com.estudoDeCaso.shopp.controllers.employee;

import com.estudoDeCaso.shopp.dto.employee.EmployeeRequestDto;
import com.estudoDeCaso.shopp.useCases.employee.UpdateEmployeeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class UpdateEmployeeController {

    private final UpdateEmployeeUseCase updateEmployeeUseCase;

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequestDto employeeRequestDto){
        this.updateEmployeeUseCase.execute(id,employeeRequestDto);
        return ResponseEntity.ok().build();
    }

}
