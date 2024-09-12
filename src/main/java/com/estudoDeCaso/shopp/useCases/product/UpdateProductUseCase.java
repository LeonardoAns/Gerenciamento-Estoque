package com.estudoDeCaso.shopp.useCases.product;

import com.estudoDeCaso.shopp.dto.product.ProductRequestDto;
import com.estudoDeCaso.shopp.entities.Product;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProductUseCase {

    private final ProductRepository productRepository;

    public void execute(Long id, ProductRequestDto productRequestDto){
        Product product = this.productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product Not Found"));
        product.setName(productRequestDto.getName());
        product.setSize(productRequestDto.getSize());
        product.setPrice(productRequestDto.getPrice());
        product.setCategory(productRequestDto.getCategory());
        this.productRepository.save(product);
    }
}
