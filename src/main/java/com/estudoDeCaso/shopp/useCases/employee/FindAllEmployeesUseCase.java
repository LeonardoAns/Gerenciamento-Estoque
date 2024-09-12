package com.estudoDeCaso.shopp.useCases.employee;

import com.estudoDeCaso.shopp.dto.employee.EmployeeResponseDto;
import com.estudoDeCaso.shopp.entities.Employee;
import com.estudoDeCaso.shopp.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindAllEmployeesUseCase {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public List<EmployeeResponseDto> execute(){
        List<Employee> employees = this.employeeRepository.findAll();
        return employees
                .stream()
                .map(employee ->
                        modelMapper.map(employee, EmployeeResponseDto.class))
                .collect(Collectors.toList());
    }
}
