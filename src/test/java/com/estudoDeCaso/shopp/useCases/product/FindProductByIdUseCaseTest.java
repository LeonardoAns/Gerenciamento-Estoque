package com.estudoDeCaso.shopp.useCases.product;

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
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.calls;
import static org.mockito.Mockito.when;

class FindProductByIdUseCaseTest {

    @InjectMocks
    private FindProductByIdUseCase findProductByIdUseCase;

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
        Product product = MockProducts.mockProduct();
        ProductResponseDto productResponseDto = MockProducts.mockProductResponseDto();

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        when(modelMapper.map(product, ProductResponseDto.class)).thenReturn(productResponseDto);

        ProductResponseDto result = findProductByIdUseCase.execute(product.getId());

        assertEquals(productResponseDto.getId(), result.getId());
        assertEquals(productResponseDto.getName(), result.getName());
        assertEquals(productResponseDto.getSize(), result.getSize());
        assertEquals(productResponseDto.getPrice(), result.getPrice());
        assertEquals(productResponseDto.getQuantity(), result.getQuantity());
        assertEquals(productResponseDto.getCategory(), result.getCategory());
    }

    @Test
    void executeProductNotFound(){
        Long id = 1L;

        when(productRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> findProductByIdUseCase.execute(id));
    }
}
