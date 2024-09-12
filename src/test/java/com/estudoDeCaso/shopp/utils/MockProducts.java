package com.estudoDeCaso.shopp.utils;

import com.estudoDeCaso.shopp.dto.product.ProductRequestDto;
import com.estudoDeCaso.shopp.dto.product.ProductResponseDto;
import com.estudoDeCaso.shopp.dto.stockHistory.StockHistoryResponseDto;
import com.estudoDeCaso.shopp.entities.Category;
import com.estudoDeCaso.shopp.entities.Product;
import com.estudoDeCaso.shopp.entities.StockHistory;
import com.estudoDeCaso.shopp.entities.enums.Size;
import java.util.ArrayList;
import java.util.List;

public class MockProducts {

    public static Long ID = 1L;
    public static String NAME = "name test";
    public static Size SIZE = Size.P;
    public static Double PRICE = 40.0;
    public static Integer QUANTITY = 20;
    public static Category CATEGORY = MockCategories.mockCategory();


    public static Product mockProduct() {
        return new Product(ID,NAME,SIZE,PRICE,QUANTITY,CATEGORY);
    }

    public static ProductResponseDto mockProductResponseDto() {
        return new ProductResponseDto(ID, NAME, SIZE, PRICE, QUANTITY, MockCategories.mockCategoryResponseDto());
    }


    public static ProductRequestDto mockProductRequestDto(){
        return new ProductRequestDto(NAME,SIZE,PRICE,QUANTITY,MockCategories.mockCategory());
    }

    public static List<Product> mockProductList(){
        Product product = mockProduct();
        List<Product> products = new ArrayList<>();
        products.add(product);
        return products;
    }


    public static List<ProductResponseDto> mockProductsResponseDto(){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        productResponseDtoList.add(productResponseDto);
        return productResponseDtoList;
    }
}