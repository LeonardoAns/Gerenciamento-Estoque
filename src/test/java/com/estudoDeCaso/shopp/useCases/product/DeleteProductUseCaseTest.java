package com.estudoDeCaso.shopp.useCases.product;

import com.estudoDeCaso.shopp.entities.Product;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.ProductRepository;
import com.estudoDeCaso.shopp.useCases.cateogry.DeleteCategoryUseCase;
import com.estudoDeCaso.shopp.utils.MockProducts;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DeleteProductUseCaseTest {

    @InjectMocks
    private DeleteProductUseCase deleteProductUseCase;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void executeSuccess() {
        Product product = MockProducts.mockProduct();

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        deleteProductUseCase.execute(product.getId());
        verify(productRepository).delete(product);

    }

    @Test
    void executeProductNotFound(){
        Long id = 1L;

        when(productRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> deleteProductUseCase.execute(id));
    }
}