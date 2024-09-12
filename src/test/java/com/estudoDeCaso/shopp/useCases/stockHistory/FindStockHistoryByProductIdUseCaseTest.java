package com.estudoDeCaso.shopp.useCases.stockHistory;

import com.estudoDeCaso.shopp.dto.product.ProductResponseDto;
import com.estudoDeCaso.shopp.dto.stockHistory.StockHistoryResponseDto;
import com.estudoDeCaso.shopp.entities.Product;
import com.estudoDeCaso.shopp.entities.StockHistory;
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

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FindStockHistoryByProductIdUseCaseTest {

    @InjectMocks
    private FindStockHistoryByProductIdUseCase findStockHistoryByProductIdUseCase;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private StockHistoryRepository stockHistoryRepository;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute() {
        Product product = MockProducts.mockProduct();
        List<StockHistory> stockHistoryList = MockStockHistory.mockStockHistoryList();
        List<StockHistoryResponseDto> stockHistoryResponseDtos = MockStockHistory.mockStockHistroyResponseDtoList();

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        when(modelMapper.map(stockHistoryList.get(0), StockHistoryResponseDto.class)).thenReturn(stockHistoryResponseDtos.get(0));
        List<StockHistoryResponseDto> result = this.findStockHistoryByProductIdUseCase.execute(product.getId());

        assertEquals(stockHistoryList.get(0).getId(), stockHistoryResponseDtos.get(0).getId());
        assertEquals(stockHistoryList.get(0).getQuantityChange(), stockHistoryResponseDtos.get(0).getQuantityChange());
        assertEquals(stockHistoryList.get(0).getChangeType(), stockHistoryResponseDtos.get(0).getChangeType());
    }
}