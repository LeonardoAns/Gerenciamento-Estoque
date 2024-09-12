package com.estudoDeCaso.shopp.useCases.product;

import com.estudoDeCaso.shopp.dto.product.ProductResponseDto;
import com.estudoDeCaso.shopp.entities.Product;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindProductByIdUseCase {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductResponseDto execute(Long id){
        Product product = this.productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product Not Found"));
        return this.modelMapper.map(product, ProductResponseDto.class);
    }
}
