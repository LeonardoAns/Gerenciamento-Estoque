package com.estudoDeCaso.shopp.useCases.stockHistory;

import com.estudoDeCaso.shopp.dto.stockHistory.StockHistoryResponseDto;
import com.estudoDeCaso.shopp.entities.Product;
import com.estudoDeCaso.shopp.entities.StockHistory;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.ProductRepository;
import com.estudoDeCaso.shopp.repositories.StockHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindStockHistoryByProductIdUseCase {

    private final StockHistoryRepository stockHistoryRepository;
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    public List<StockHistoryResponseDto> execute(Long id){
        Product product = this.productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product Not Found"));
        List<StockHistory> productsStockHistory = this.stockHistoryRepository.findStockHistoryByProductId(product.getId());
        return productsStockHistory
                .stream()
                .map(stockHistory ->
                        modelMapper.map(stockHistory, StockHistoryResponseDto.class))
                .collect(Collectors.toList());

    }
}
