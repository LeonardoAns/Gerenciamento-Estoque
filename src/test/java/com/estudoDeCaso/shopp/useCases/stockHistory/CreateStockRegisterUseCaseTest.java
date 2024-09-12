package com.estudoDeCaso.shopp.useCases.stockHistory;

import com.estudoDeCaso.shopp.entities.Product;
import com.estudoDeCaso.shopp.entities.StockHistory;
import com.estudoDeCaso.shopp.entities.enums.ChangeType;
import com.estudoDeCaso.shopp.repositories.StockHistoryRepository;
import com.estudoDeCaso.shopp.utils.MockProducts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CreateStockRegisterUseCaseTest {

    @InjectMocks
    private CreateStockRegisterUseCase createStockRegisterUseCase;

    @Mock
    private StockHistoryRepository stockHistoryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute() {
        Product product = MockProducts.mockProduct();
        StockHistory stockHistory = new StockHistory();
        stockHistory.setProduct(product);
        stockHistory.setQuantityChange(product.getQuantity());
        stockHistory.setChangeType(ChangeType.ADDITION);

        createStockRegisterUseCase.execute(product);

        verify(stockHistoryRepository).save(stockHistory);
        assertEquals(stockHistory.getProduct(), product);
        assertEquals(stockHistory.getQuantityChange(), product.getQuantity());
        assertEquals(stockHistory.getChangeType(), ChangeType.ADDITION);
    }
}