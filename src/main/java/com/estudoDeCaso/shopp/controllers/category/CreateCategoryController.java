package com.estudoDeCaso.shopp.controllers.category;

import com.estudoDeCaso.shopp.dto.category.CategoryRequestDto;
import com.estudoDeCaso.shopp.useCases.cateogry.CreateCategoryUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CreateCategoryController {

    private final CreateCategoryUseCase createCategoryUseCase;

    @PostMapping
    public ResponseEntity<URI> createCategory(@Valid @RequestBody CategoryRequestDto categoryRequestDto){
        Long categoryId = this.createCategoryUseCase.execute(categoryRequestDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoryId)
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
