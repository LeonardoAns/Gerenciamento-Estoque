package com.estudoDeCaso.shopp.useCases.cateogry;

import com.estudoDeCaso.shopp.dto.category.CategoryRequestDto;
import com.estudoDeCaso.shopp.entities.Category;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.CategoryRepository;
import com.estudoDeCaso.shopp.utils.MockCategories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UpdateCategoryUseCaseTest {

    @InjectMocks
    private UpdateCategoryUseCase updateCategoryUseCase;

    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void executeSuccess() {
        Category category = MockCategories.mockCategory();
        CategoryRequestDto categoryRequestDto = MockCategories.mockCategoryRequestDto();

        when(categoryRepository.findById(category.getId())).thenReturn(Optional.of(category));
        updateCategoryUseCase.execute(category.getId(),categoryRequestDto);
        verify(categoryRepository).save(category);
    }

    @Test
    void executeCategoryNotFound(){
        Long id = 1L;
        CategoryRequestDto categoryRequestDto = new CategoryRequestDto("Test");

        when(categoryRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> updateCategoryUseCase.execute(id,categoryRequestDto));
    }
}