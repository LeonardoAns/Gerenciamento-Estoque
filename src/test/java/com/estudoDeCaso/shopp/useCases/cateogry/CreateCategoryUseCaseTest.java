package com.estudoDeCaso.shopp.useCases.cateogry;

import com.estudoDeCaso.shopp.dto.category.CategoryRequestDto;
import com.estudoDeCaso.shopp.dto.category.CategoryResponseDto;
import com.estudoDeCaso.shopp.entities.Category;
import com.estudoDeCaso.shopp.repositories.CategoryRepository;
import com.estudoDeCaso.shopp.utils.MockCategories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateCategoryUseCaseTest {

    @InjectMocks
    private CreateCategoryUseCase createCategoryUseCase;

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
        CategoryRequestDto categoryRequestDto = MockCategories.mockCategoryRequestDto();

        when(modelMapper.map(categoryRequestDto, Category.class)).thenReturn(category);

        createCategoryUseCase.execute(categoryRequestDto);

        verify(categoryRepository).save(category);

    }
}