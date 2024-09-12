package com.estudoDeCaso.shopp.useCases.employee;

import com.estudoDeCaso.shopp.entities.Employee;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteEmployeeUseCase {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public void execute(Long id){
        Employee employee = this.employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found"));
        this.employeeRepository.delete(employee);
    }

}
