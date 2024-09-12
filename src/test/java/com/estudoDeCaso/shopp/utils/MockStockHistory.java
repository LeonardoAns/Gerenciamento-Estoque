package com.estudoDeCaso.shopp.utils;

import com.estudoDeCaso.shopp.dto.stockHistory.StockHistoryResponseDto;
import com.estudoDeCaso.shopp.entities.Product;
import com.estudoDeCaso.shopp.entities.StockHistory;
import com.estudoDeCaso.shopp.entities.enums.ChangeType;

import java.time.LocalDateTime;
import java.util.List;

public class MockStockHistory {

    private static Long ID = 1L;
    private static Product PRODUCT = MockProducts.mockProduct();
    private static Integer QUANTITY_CHANGE = 10;
    private static ChangeType CHANGE_TYPE = ChangeType.ADDITION;
    private static LocalDateTime CHANGEAT = LocalDateTime.now();

    public static StockHistory mockStockHistory(){
        return new StockHistory(ID,PRODUCT,QUANTITY_CHANGE,CHANGE_TYPE,CHANGEAT);
    }

    public static StockHistoryResponseDto mockStockHistoryResponseDto(){
        return new StockHistoryResponseDto(ID,QUANTITY_CHANGE,CHANGE_TYPE,CHANGEAT);
    }

    public static List<StockHistoryResponseDto> mockStockHistroyResponseDtoList(){
        StockHistoryResponseDto stockHistoryResponseDto = mockStockHistoryResponseDto();
        return List.of(stockHistoryResponseDto);
    }

    public static StockHistoryResponseDto mockStockHistoryReplaceDto(){
        return new StockHistoryResponseDto(ID,QUANTITY_CHANGE,ChangeType.REPLACEMENT,CHANGEAT);
    }

    public static List<StockHistory> mockStockHistoryList(){
        StockHistory stockHistory = mockStockHistory();
        return List.of(stockHistory);
    }

}
