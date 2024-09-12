package com.estudoDeCaso.shopp.useCases.employee;

import com.estudoDeCaso.shopp.dto.employee.EmployeeRequestDto;
import com.estudoDeCaso.shopp.entities.Employee;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateEmployeeUseCase {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public void execute(Long id, EmployeeRequestDto employeeRequestDto){
        Employee employee = this.employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found"));


        employee.setName(employeeRequestDto.getName());
        employee.setCpf(employeeRequestDto.getCpf());
        employee.setEmail(employeeRequestDto.getEmail());
        employee.setPhone(employeeRequestDto.getPhone());
        employee.setAddress(employeeRequestDto.getAddress());
        employee.setBirthDate(employeeRequestDto.getBirthDate());
        employee.setWage(employeeRequestDto.getWage());
        employee.setRoles(employeeRequestDto.getRoles());
        
        this.employeeRepository.save(employee);
    }
}
