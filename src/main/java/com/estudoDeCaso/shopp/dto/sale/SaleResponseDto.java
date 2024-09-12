package com.estudoDeCaso.shopp.dto.sale;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleResponseDto {
    private List<ProductSaleResponseDto> productList;

    @JsonFormat(pattern = "MM/dd/yyyy/ HH:mm:ss")
    private LocalDateTime saleDate;
}
