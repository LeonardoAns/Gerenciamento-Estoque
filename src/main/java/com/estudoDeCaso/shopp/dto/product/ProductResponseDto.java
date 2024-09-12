package com.estudoDeCaso.shopp.dto.product;

import com.estudoDeCaso.shopp.dto.category.CategoryResponseDto;
import com.estudoDeCaso.shopp.entities.enums.Size;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

    private Long id;
    private String name;
    private Size size;
    private Double price;
    private Integer quantity;

    @JsonBackReference
    private CategoryResponseDto category;
}