package com.estudoDeCaso.shopp.useCases.stockHistory;

import com.estudoDeCaso.shopp.entities.Product;
import com.estudoDeCaso.shopp.entities.StockHistory;
import com.estudoDeCaso.shopp.entities.enums.ChangeType;
import com.estudoDeCaso.shopp.repositories.StockHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateStockRegisterUseCase {

    private final StockHistoryRepository stockHistoryRepository;

    public void execute(Product product){
        StockHistory stockHistory = new StockHistory();
        stockHistory.setProduct(product);
        stockHistory.setQuantityChange(product.getQuantity());
        stockHistory.setChangeType(ChangeType.ADDITION);
        this.stockHistoryRepository.save(stockHistory);
    }
}
