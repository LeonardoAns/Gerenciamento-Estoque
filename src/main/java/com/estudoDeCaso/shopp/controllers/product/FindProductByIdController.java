package com.estudoDeCaso.shopp.controllers.product;


import com.estudoDeCaso.shopp.dto.product.ProductResponseDto;
import com.estudoDeCaso.shopp.useCases.product.FindProductByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class FindProductByIdController {

    private final FindProductByIdUseCase findProductByIdUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> findProductById(@PathVariable Long id){
        ProductResponseDto productResponseDto = this.findProductByIdUseCase.execute(id);
        return ResponseEntity.ok().body(productResponseDto);
    }
}
