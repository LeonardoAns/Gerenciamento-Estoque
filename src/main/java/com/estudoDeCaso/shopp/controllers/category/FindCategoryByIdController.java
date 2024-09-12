package com.estudoDeCaso.shopp.controllers.category;

import com.estudoDeCaso.shopp.dto.category.CategoryResponseDto;
import com.estudoDeCaso.shopp.useCases.cateogry.FindCategoryByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class FindCategoryByIdController {

    private final FindCategoryByIdUseCase findCategoryByIdUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> findCategoryById(@PathVariable Long id){
        CategoryResponseDto categoryResponseDto = this.findCategoryByIdUseCase.execute(id);
        return ResponseEntity.ok().body(categoryResponseDto);
    }
}
