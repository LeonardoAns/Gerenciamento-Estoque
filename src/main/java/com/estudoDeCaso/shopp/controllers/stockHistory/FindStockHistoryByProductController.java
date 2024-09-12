package com.estudoDeCaso.shopp.controllers.stockHistory;

import com.estudoDeCaso.shopp.dto.stockHistory.StockHistoryResponseDto;
import com.estudoDeCaso.shopp.useCases.stockHistory.FindStockHistoryByProductIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product_history")
@RequiredArgsConstructor
public class FindStockHistoryByProductController {

    private final FindStockHistoryByProductIdUseCase findStockHistoryByProductUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<List<StockHistoryResponseDto>> findStockHistoryByName(@PathVariable Long id){
        List<StockHistoryResponseDto> stockHistoryResponseDtos = this.findStockHistoryByProductUseCase.execute(id);
        return ResponseEntity.ok().body(stockHistoryResponseDtos);
    }
}
