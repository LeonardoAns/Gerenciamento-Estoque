package com.estudoDeCaso.shopp.dto.product;

import com.estudoDeCaso.shopp.entities.Category;
import com.estudoDeCaso.shopp.entities.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {

    private String name;
    private Size size;
    private Double price;
    private Integer quantity;
    private Category category;
}
