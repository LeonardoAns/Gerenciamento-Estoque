package com.estudoDeCaso.shopp.useCases.product;

import com.estudoDeCaso.shopp.entities.Product;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProductUseCase {

    private final ProductRepository productRepository;

    public void execute(Long id){
        Product product = this.productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product Not Found"));
        this.productRepository.delete(product);
    }
}

