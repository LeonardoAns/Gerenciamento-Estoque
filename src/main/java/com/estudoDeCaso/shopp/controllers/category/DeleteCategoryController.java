package com.estudoDeCaso.shopp.controllers.category;

import com.estudoDeCaso.shopp.useCases.cateogry.DeleteCategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class DeleteCategoryController {

    private final DeleteCategoryUseCase deleteCategoryUseCase;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCateogry(@PathVariable Long id){
        this.deleteCategoryUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
