package com.estudoDeCaso.shopp.controllers.employee;

import com.estudoDeCaso.shopp.useCases.employee.DeleteEmployeeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class DeleteEmployeeController {

    private final DeleteEmployeeUseCase deleteEmployeeUseCase;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        this.deleteEmployeeUseCase.execute(id);
        return ResponseEntity.ok().build();
    }
}
