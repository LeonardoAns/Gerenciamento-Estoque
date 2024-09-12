package com.estudoDeCaso.shopp.useCases.cateogry;

import com.estudoDeCaso.shopp.dto.category.CategoryResponseDto;
import com.estudoDeCaso.shopp.entities.Category;
import com.estudoDeCaso.shopp.entities.Product;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.CategoryRepository;
import com.estudoDeCaso.shopp.repositories.ProductRepository;
import com.estudoDeCaso.shopp.utils.MockCategories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DeleteCategoryUseCaseTest {

    @InjectMocks
    private DeleteCategoryUseCase deleteCategoryUseCase;

    @Mock
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void executeSuccess(){
        Category category = MockCategories.mockCategory();
        Product product = new Product();
        product.setCategory(category);
        category.setProducts(List.of(product));

        when(categoryRepository.findById(category.getId())).thenReturn(Optional.of(category));
        deleteCategoryUseCase.execute(category.getId());
        verify(categoryRepository).delete(category);
    }

    @Test
    void executeCategoryNotFound(){
        Long id = 1L;

        when(categoryRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> deleteCategoryUseCase.execute(id));
    }
}