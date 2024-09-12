package com.estudoDeCaso.shopp.useCases.product;

import com.estudoDeCaso.shopp.dto.product.ProductResponseDto;
import com.estudoDeCaso.shopp.entities.Product;
import com.estudoDeCaso.shopp.repositories.ProductRepository;
import com.estudoDeCaso.shopp.utils.MockProducts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockitoPostProcessor;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class FindAllProductsUseCaseTest {

    @InjectMocks
    private FindAllProductsUseCase findAllProductsUseCase;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void executeSuccess() {
        List<Product> productList = MockProducts.mockProductList();
        List<ProductResponseDto> productResponseDtoList = MockProducts.mockProductsResponseDto();

        when(productRepository.findAll()).thenReturn(productList);
        when(modelMapper.map(productList.get(0), ProductResponseDto.class)).thenReturn(productResponseDtoList.get(0));

        List<ProductResponseDto> result = this.findAllProductsUseCase.execute();

        assertEquals(productResponseDtoList.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            assertEquals(productResponseDtoList.get(i).getId(), result.get(i).getId());
        }
    }
}
