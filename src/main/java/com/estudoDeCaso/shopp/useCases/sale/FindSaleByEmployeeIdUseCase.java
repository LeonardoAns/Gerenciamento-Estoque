package com.estudoDeCaso.shopp.useCases.sale;

import com.estudoDeCaso.shopp.dto.sale.SaleResponseDto;
import com.estudoDeCaso.shopp.entities.Employee;
import com.estudoDeCaso.shopp.entities.Sale;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.EmployeeRepository;
import com.estudoDeCaso.shopp.repositories.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindSaleByEmployeeIdUseCase {

    private final SaleRepository saleRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public List<SaleResponseDto> execute(Long id){
        Employee employee = this.employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee Not Found"));

        List<Sale> sales = this.saleRepository.findSalesByEmployeeId(employee.getId());
        return sales.stream().map(sale -> modelMapper.map(sale, SaleResponseDto.class)).toList();
    }

}
