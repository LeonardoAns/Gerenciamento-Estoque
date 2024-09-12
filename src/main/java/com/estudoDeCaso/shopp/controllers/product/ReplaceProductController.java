package com.estudoDeCaso.shopp.controllers.product;

import com.estudoDeCaso.shopp.dto.product.ProductRequestDto;
import com.estudoDeCaso.shopp.useCases.product.ReplaceProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ReplaceProductController {

    private final ReplaceProductUseCase replaceProductUseCase;

    @PutMapping("/replace/{id}")
    public ResponseEntity<Void> replaceProduct(@PathVariable Long id, @RequestBody ProductRequestDto productRequestDto){
        this.replaceProductUseCase.execute(id,productRequestDto);
        return ResponseEntity.ok().build();
    }
}
