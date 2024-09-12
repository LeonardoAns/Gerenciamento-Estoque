package com.estudoDeCaso.shopp.controllers.sale;


import com.estudoDeCaso.shopp.dto.sale.SaleRequestDto;
import com.estudoDeCaso.shopp.useCases.sale.RegisterSaleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class RegisterSaleController {

    private final RegisterSaleUseCase registerSaleUseCase;

    @PostMapping("/{id}")
    public ResponseEntity<Void> registerSale(@PathVariable Long id, @RequestBody SaleRequestDto saleRequestDto){
        this.registerSaleUseCase.execute(id,saleRequestDto);
        return ResponseEntity.ok().build();
    }
}
