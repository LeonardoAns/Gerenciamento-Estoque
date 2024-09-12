package com.estudoDeCaso.shopp.controllers.product;

import com.estudoDeCaso.shopp.dto.product.ProductRequestDto;
import com.estudoDeCaso.shopp.repositories.ProductRepository;
import com.estudoDeCaso.shopp.useCases.product.CreateProductUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class CreateProductController {

    private final CreateProductUseCase createProductUseCase;

    @PostMapping
    public ResponseEntity<URI> createProduct(@Valid @RequestBody ProductRequestDto productRequestDto){
        Long productId = this.createProductUseCase.execute(productRequestDto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productId)
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
