package com.estudoDeCaso.shopp.controllers.category;

import com.estudoDeCaso.shopp.dto.category.CategoryResponseDto;
import com.estudoDeCaso.shopp.useCases.cateogry.FindAllCategoriesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class FindAllCategoriesController {

    private final FindAllCategoriesUseCase findAllCategoriesUseCase;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> findAllCategories(){
        List<CategoryResponseDto> categoryResponseDto = this.findAllCategoriesUseCase.execute();
        return ResponseEntity.ok().body(categoryResponseDto);
    }
}
