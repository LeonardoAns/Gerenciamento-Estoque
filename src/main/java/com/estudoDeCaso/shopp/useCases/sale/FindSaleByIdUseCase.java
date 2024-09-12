package com.estudoDeCaso.shopp.useCases.sale;

import com.estudoDeCaso.shopp.dto.sale.SaleResponseDto;
import com.estudoDeCaso.shopp.entities.Employee;
import com.estudoDeCaso.shopp.entities.Sale;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindSaleByIdUseCase {

    private final SaleRepository saleRepository;
    private final ModelMapper modelMapper;

    public SaleResponseDto execute(Long id){
        Sale sale = this.saleRepository.findById(id).orElseThrow(() -> new NotFoundException("Sale Not Found"));

        return modelMapper.map(sale, SaleResponseDto.class);

    }
}
