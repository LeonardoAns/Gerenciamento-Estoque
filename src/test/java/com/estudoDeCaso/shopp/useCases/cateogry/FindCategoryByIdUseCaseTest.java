package com.estudoDeCaso.shopp.useCases.cateogry;

import com.estudoDeCaso.shopp.dto.category.CategoryResponseDto;
import com.estudoDeCaso.shopp.entities.Category;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.CategoryRepository;
import com.estudoDeCaso.shopp.utils.MockCategories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FindCategoryByIdUseCaseTest {

    @InjectMocks
    private FindCategoryByIdUseCase findCategoryByIdUseCase;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void executeSuccess() {
        Category category = MockCategories.mockCategory();
        CategoryResponseDto categoryResponseDto = MockCategories.mockCategoryResponseDto();
        Long id = category.getId();

        when(categoryRepository.findById(category.getId())).thenReturn(Optional.of(category));
        when(modelMapper.map(category, CategoryResponseDto.class)).thenReturn(categoryResponseDto);
        when(findCategoryByIdUseCase.execute(id)).thenReturn(categoryResponseDto);

        assertEquals(category.getId(),categoryResponseDto.getId());
        assertEquals(category.getName(),categoryResponseDto.getName());
    }

    @Test
    void executeCategoryNotFound(){
        Long id = 1L;

        when(categoryRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> findCategoryByIdUseCase.execute(id));
    }
}