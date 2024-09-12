package com.estudoDeCaso.shopp.dto.category;

import com.estudoDeCaso.shopp.dto.product.ProductResponseDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDto {

    private Long id;
    private String name;

    @JsonManagedReference
    private List<ProductResponseDto> products = new ArrayList<>();

    public CategoryResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
