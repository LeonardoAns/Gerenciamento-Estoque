package com.estudoDeCaso.shopp.useCases.stockHistory;

import com.estudoDeCaso.shopp.dto.stockHistory.StockHistoryDateRequestDto;
import com.estudoDeCaso.shopp.dto.stockHistory.StockHistoryResponseDto;
import com.estudoDeCaso.shopp.entities.StockHistory;
import com.estudoDeCaso.shopp.exceptions.InvalidRequestException;
import com.estudoDeCaso.shopp.repositories.StockHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindStockHistoryByDateUseCase {

    private final StockHistoryRepository stockHistoryRepository;
    private final ModelMapper modelMapper;

    public List<StockHistoryResponseDto> execute(StockHistoryDateRequestDto stockHistoryDateRequestDto){

        if(stockHistoryDateRequestDto.getInitialDate().isAfter(LocalDateTime.now())|| stockHistoryDateRequestDto.getFinalDate().isAfter(LocalDateTime.now())){
            throw new InvalidRequestException("Initial or final date cannot be in the future.");
        }
        List<StockHistory> stockHistoriyList = this.stockHistoryRepository.findStockHistoryByDate(stockHistoryDateRequestDto.getInitialDate(),stockHistoryDateRequestDto.getFinalDate());
        return stockHistoriyList.stream().map(stock ->
                modelMapper.map(stock, StockHistoryResponseDto.class))
                .toList();

    }
}
