package com.estudoDeCaso.shopp.useCases.employee;

import com.estudoDeCaso.shopp.dto.employee.EmployeeResponseDto;
import com.estudoDeCaso.shopp.entities.Employee;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindEmployeeByIdUseCase {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeResponseDto execute(Long id){
        Employee employee = this.employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found"));
        return modelMapper.map(employee, EmployeeResponseDto.class);
    }
}
