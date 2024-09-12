package com.estudoDeCaso.shopp.useCases.employee;

import com.estudoDeCaso.shopp.dto.employee.EmployeeRequestDto;
import com.estudoDeCaso.shopp.entities.Employee;
import com.estudoDeCaso.shopp.exceptions.AlreadyExistsException;
import com.estudoDeCaso.shopp.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateEmployeeUseCase{

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public Long execute(EmployeeRequestDto employeeRequestDto){
        Employee employee = this.modelMapper.map(employeeRequestDto, Employee.class);
        if(this.employeeRepository.existsByCpf(employee.getCpf())){
            throw new AlreadyExistsException("Employee already exists");
        }
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        this.employeeRepository.save(employee);
        return employee.getId();
    };

}
