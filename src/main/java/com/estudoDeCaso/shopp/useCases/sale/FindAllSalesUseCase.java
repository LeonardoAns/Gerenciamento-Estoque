package com.estudoDeCaso.shopp.useCases.sale;

import com.estudoDeCaso.shopp.dto.sale.SaleResponseDto;
import com.estudoDeCaso.shopp.entities.Sale;
import com.estudoDeCaso.shopp.repositories.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllSalesUseCase {

    private final SaleRepository saleRepository;
    private final ModelMapper modelMapper;

    public List<SaleResponseDto> execute(){
        List<Sale> sales = this.saleRepository.findAll();
        return sales.stream().map(sale ->
                        modelMapper.map(sale, SaleResponseDto.class))
                .toList();
    }
}
