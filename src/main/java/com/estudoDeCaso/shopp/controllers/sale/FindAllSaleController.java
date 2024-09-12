package com.estudoDeCaso.shopp.controllers.sale;

import com.estudoDeCaso.shopp.useCases.sale.FindAllSalesUseCase;
import com.estudoDeCaso.shopp.dto.sale.SaleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sales")
@RequiredArgsConstructor
public class FindAllSaleController {

    private final FindAllSalesUseCase findAllSalesUseCase;

    @GetMapping
    public ResponseEntity<List<SaleResponseDto>> findAllSales(){
        List<SaleResponseDto> saleResponseDtos = this.findAllSalesUseCase.execute();
        return ResponseEntity.ok(saleResponseDtos);
    }
}
