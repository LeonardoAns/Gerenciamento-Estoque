package com.estudoDeCaso.shopp.useCases.sale;

import com.estudoDeCaso.shopp.dto.sale.SaleRequestDto;
import com.estudoDeCaso.shopp.entities.Sale;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteSaleUseCase {

    private final SaleRepository saleRepository;

    public void execute(Long id){
        Sale sale = this.saleRepository.findById(id).orElseThrow(() -> new NotFoundException("Sale Not Found"));
        this.saleRepository.delete(sale);

    }
}
