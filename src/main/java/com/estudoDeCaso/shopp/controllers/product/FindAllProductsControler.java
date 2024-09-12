package com.estudoDeCaso.shopp.controllers.product;

import com.estudoDeCaso.shopp.dto.product.ProductResponseDto;
import com.estudoDeCaso.shopp.useCases.product.FindAllProductsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class FindAllProductsControler {

    private final FindAllProductsUseCase findAllProductsUseCase;

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> findAllProducts(){
        List<ProductResponseDto> productResponseDtos = this.findAllProductsUseCase.execute();
        return ResponseEntity.ok().body(productResponseDtos);
    }
}
