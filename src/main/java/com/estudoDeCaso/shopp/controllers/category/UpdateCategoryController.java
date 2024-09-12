package com.estudoDeCaso.shopp.controllers.category;

import com.estudoDeCaso.shopp.dto.category.CategoryRequestDto;
import com.estudoDeCaso.shopp.useCases.cateogry.UpdateCategoryUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class UpdateCategoryController {

    private final UpdateCategoryUseCase updateCategoryUseCase;

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryRequestDto categoryRequestDto){
        this.updateCategoryUseCase.execute(id,categoryRequestDto);
        return ResponseEntity.ok().build();
    }
}
