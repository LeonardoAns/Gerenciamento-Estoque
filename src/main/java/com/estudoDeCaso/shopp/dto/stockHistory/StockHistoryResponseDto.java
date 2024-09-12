package com.estudoDeCaso.shopp.dto.stockHistory;

import com.estudoDeCaso.shopp.entities.enums.ChangeType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockHistoryResponseDto {

    private Long id;
    private Integer quantityChange;
    private ChangeType changeType;

    @JsonFormat(pattern = "MM/dd/yyyy/ HH:mm:ss")
    private LocalDateTime changeDate;

}
