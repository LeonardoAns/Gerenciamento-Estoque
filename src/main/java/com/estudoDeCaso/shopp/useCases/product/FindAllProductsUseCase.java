package com.estudoDeCaso.shopp.useCases.product;

import com.estudoDeCaso.shopp.dto.product.ProductResponseDto;
import com.estudoDeCaso.shopp.entities.Product;
import com.estudoDeCaso.shopp.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindAllProductsUseCase {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public List<ProductResponseDto> execute(){
        List<Product> products = this.productRepository.findAll();
        return products
                .stream()
                .map(product ->
                        this.modelMapper.map(product, ProductResponseDto.class))
                .collect(Collectors.toList());
    }
}
