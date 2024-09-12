package com.estudoDeCaso.shopp.useCases.product;

import com.estudoDeCaso.shopp.dto.product.ProductRequestDto;
import com.estudoDeCaso.shopp.entities.Product;
import com.estudoDeCaso.shopp.entities.StockHistory;
import com.estudoDeCaso.shopp.exceptions.InvalidRequestException;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.ProductRepository;
import com.estudoDeCaso.shopp.repositories.StockHistoryRepository;
import com.estudoDeCaso.shopp.utils.MockProducts;
import com.estudoDeCaso.shopp.utils.MockStockHistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockitoPostProcessor;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ReplaceProductUseCaseTest {

    @InjectMocks
    private ReplaceProductUseCase replaceProductUseCase;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StockHistoryRepository stockHistoryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute() {
        Product product = MockProducts.mockProduct();
        ProductRequestDto productRequestDto = MockProducts.mockProductRequestDto();
        StockHistory stockHistory = MockStockHistory.mockStockHistory();

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        product.setQuantity(productRequestDto.getQuantity());
        this.replaceProductUseCase.execute(product.getId(),productRequestDto);
        verify(productRepository).save(product);

        assertEquals(product.getQuantity(), productRequestDto.getQuantity());
        assertEquals(productRequestDto.getName(), product.getName());
        assertEquals(productRequestDto.getSize(), product.getSize());
    }

    @Test
    void executeInvalidRequestDtoException(){
        Product product = MockProducts.mockProduct();
        ProductRequestDto productRequestDto = MockProducts.mockProductRequestDto();
        productRequestDto.setQuantity(1);

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        assertThrows(InvalidRequestException.class, () -> replaceProductUseCase.execute(product.getId(),productRequestDto));
    }

    @Test
    void executeStockHistoryNotFoundException(){
        Long id = 1L;
        ProductRequestDto productRequestDto = MockProducts.mockProductRequestDto();

        when(productRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class,() -> replaceProductUseCase.execute(id,productRequestDto));
    }
}