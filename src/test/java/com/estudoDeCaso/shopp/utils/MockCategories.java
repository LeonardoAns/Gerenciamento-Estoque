package com.estudoDeCaso.shopp.utils;

import com.estudoDeCaso.shopp.dto.category.CategoryRequestDto;
import com.estudoDeCaso.shopp.dto.category.CategoryResponseDto;
import com.estudoDeCaso.shopp.entities.Category;
import com.estudoDeCaso.shopp.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class MockCategories {

    public static Long ID = 1L;
    public static String NAME = "name test";
    public static List<Product> PRODUCTS = List.of(MockProducts.mockProduct());

     public static Category mockCategory(){
        return new Category(ID,NAME);
    }

    public static CategoryResponseDto mockCategoryResponseDto(){
        return new CategoryResponseDto(ID,NAME,MockProducts.mockProductsResponseDto());
    }

    public static CategoryRequestDto mockCategoryRequestDto(){
        return new CategoryRequestDto(NAME);
    }

    public static List<Category> mockCategoryList(){
        Category category = new Category();
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(category);
        return categoryList;
    }

    public static List<CategoryResponseDto> mockCategoriesResponseDto(){
         CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
         List<CategoryResponseDto> categoryResponseDtoList = new ArrayList<>();
         categoryResponseDtoList.add(categoryResponseDto);
         return categoryResponseDtoList;
    }
}
