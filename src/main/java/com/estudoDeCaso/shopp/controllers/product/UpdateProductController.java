package com.estudoDeCaso.shopp.controllers.product;

import com.estudoDeCaso.shopp.dto.product.ProductRequestDto;
import com.estudoDeCaso.shopp.useCases.product.UpdateProductUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class UpdateProductController {

    private final UpdateProductUseCase updateProductUseCase;

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequestDto productRequestDto){
        this.updateProductUseCase.execute(id,productRequestDto);
        return ResponseEntity.ok().build();
    }
}
