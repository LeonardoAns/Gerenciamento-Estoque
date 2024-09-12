package com.estudoDeCaso.shopp.useCases.cateogry;

import com.estudoDeCaso.shopp.dto.category.CategoryResponseDto;
import com.estudoDeCaso.shopp.entities.Category;
import com.estudoDeCaso.shopp.repositories.CategoryRepository;
import com.estudoDeCaso.shopp.utils.MockCategories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class FindAllCategoriesUseCaseTest {

    @InjectMocks
    FindAllCategoriesUseCase findAllCategoriesUseCase;

    @Mock
    CategoryRepository categoryRepository;

    @Mock
    ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void executeSuccess() {
        List<Category> mockCategories = MockCategories.mockCategoryList();
        CategoryResponseDto mockCategoryResponseDto = MockCategories.mockCategoryResponseDto();

        when(categoryRepository.findAll()).thenReturn(MockCategories.mockCategoryList());
        when(modelMapper.map(mockCategories.get(0), CategoryResponseDto.class)).thenReturn(mockCategoryResponseDto);

        List<CategoryResponseDto> result = this.findAllCategoriesUseCase.execute();

        assertEquals(1, result.size());
        assertEquals(mockCategoryResponseDto.getId(), result.get(0).getId());
        assertEquals(mockCategoryResponseDto.getName(), result.get(0).getName());
    }
}