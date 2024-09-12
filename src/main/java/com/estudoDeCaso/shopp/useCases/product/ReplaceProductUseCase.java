package com.estudoDeCaso.shopp.useCases.product;

import com.estudoDeCaso.shopp.dto.product.ProductRequestDto;
import com.estudoDeCaso.shopp.entities.Product;
import com.estudoDeCaso.shopp.entities.StockHistory;
import com.estudoDeCaso.shopp.entities.enums.ChangeType;
import com.estudoDeCaso.shopp.exceptions.InvalidRequestException;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.ProductRepository;
import com.estudoDeCaso.shopp.repositories.StockHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplaceProductUseCase {

    private final ProductRepository productRepository;
    private final StockHistoryRepository stockHistoryRepository;

    public void execute(Long id,ProductRequestDto productRequestDto) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product Not Found"));

        if (productRequestDto.getQuantity() < product.getQuantity()) {
            throw new InvalidRequestException("The quantity of products is lower than existing");
        }
        product.setQuantity(productRequestDto.getQuantity());
        this.productRepository.save(product);


        StockHistory stockHistory = new StockHistory();
        stockHistory.setProduct(product);
        stockHistory.setQuantityChange(product.getQuantity());
        stockHistory.setChangeType(ChangeType.REPLACEMENT);
        this.stockHistoryRepository.save(stockHistory);
    }
}
