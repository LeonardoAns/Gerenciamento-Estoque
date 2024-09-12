package com.estudoDeCaso.shopp.controllers.stockHistory;

import com.estudoDeCaso.shopp.dto.stockHistory.StockHistoryDateRequestDto;
import com.estudoDeCaso.shopp.dto.stockHistory.StockHistoryResponseDto;
import com.estudoDeCaso.shopp.useCases.stockHistory.FindStockHistoryByDateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock_history")
@RequiredArgsConstructor
public class FindStockHistoryByDateController {

    private final FindStockHistoryByDateUseCase findStockHistoryByDateUseCase;

    @GetMapping
    public ResponseEntity<List<StockHistoryResponseDto>> findByDate(@RequestBody StockHistoryDateRequestDto stockHistoryDateRequestDto){
        List<StockHistoryResponseDto> stockHistoryResponseDtos = this.findStockHistoryByDateUseCase.execute(stockHistoryDateRequestDto);
        return ResponseEntity.ok(stockHistoryResponseDtos);
    }
}
