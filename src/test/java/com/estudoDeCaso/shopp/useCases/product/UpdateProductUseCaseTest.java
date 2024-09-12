package com.estudoDeCaso.shopp.useCases.product;

import com.estudoDeCaso.shopp.dto.category.CategoryRequestDto;
import com.estudoDeCaso.shopp.dto.product.ProductRequestDto;
import com.estudoDeCaso.shopp.dto.product.ProductResponseDto;
import com.estudoDeCaso.shopp.entities.Product;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.ProductRepository;
import com.estudoDeCaso.shopp.utils.MockProducts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UpdateProductUseCaseTest {

    @InjectMocks
    private UpdateProductUseCase updateProductUseCase;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void executeSuccess() {
        Product product = MockProducts.mockProduct();
        ProductRequestDto productRequestDto = MockProducts.mockProductRequestDto();

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        updateProductUseCase.execute(product.getId(),productRequestDto);
        verify(productRepository).save(product);
    }

    @Test
    void executeProductNotFound(){
        Long id = 1L;
        ProductRequestDto productRequestDto = MockProducts.mockProductRequestDto();

        when(productRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class,() -> updateProductUseCase.execute(id,productRequestDto));
    }
}