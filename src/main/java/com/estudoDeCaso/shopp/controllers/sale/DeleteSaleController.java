package com.estudoDeCaso.shopp.controllers.sale;

import com.estudoDeCaso.shopp.useCases.sale.DeleteSaleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
@RequiredArgsConstructor
public class DeleteSaleController {

    private final DeleteSaleUseCase deleteSaleUseCase;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id){
        this.deleteSaleUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
