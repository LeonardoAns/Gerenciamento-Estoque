package com.estudoDeCaso.shopp.controllers.sale;

import com.estudoDeCaso.shopp.dto.sale.SaleResponseDto;
import com.estudoDeCaso.shopp.useCases.sale.FindSaleByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
@RequiredArgsConstructor
public class FindSaleByIdController {

    private final FindSaleByIdUseCase findSaleByIdUseCase;

    @GetMapping("/employee/{id}")
    public ResponseEntity<SaleResponseDto> findSaleById(@PathVariable Long id){
        SaleResponseDto saleResponseDto = this.findSaleByIdUseCase.execute(id);
        return ResponseEntity.ok(saleResponseDto);
    }
}
