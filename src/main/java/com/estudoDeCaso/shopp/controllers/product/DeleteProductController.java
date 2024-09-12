package com.estudoDeCaso.shopp.controllers.product;

import com.estudoDeCaso.shopp.useCases.product.DeleteProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class DeleteProductController {

    private final DeleteProductUseCase deleteProductUseCase;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        this.deleteProductUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
