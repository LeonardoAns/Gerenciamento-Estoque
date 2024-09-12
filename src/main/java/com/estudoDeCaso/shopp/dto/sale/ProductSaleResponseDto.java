package com.estudoDeCaso.shopp.dto.sale;

import com.estudoDeCaso.shopp.entities.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSaleResponseDto {

    private Long id;
    private String name;
    private Size size;
    private Double price;
    private Integer quantity;
}
