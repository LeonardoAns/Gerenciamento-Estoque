package com.estudoDeCaso.shopp.useCases.product;

import com.estudoDeCaso.shopp.dto.product.ProductRequestDto;
import com.estudoDeCaso.shopp.entities.Product;
import com.estudoDeCaso.shopp.entities.StockHistory;
import com.estudoDeCaso.shopp.exceptions.AlreadyExistsException;
import com.estudoDeCaso.shopp.exceptions.InvalidRequestException;
import com.estudoDeCaso.shopp.repositories.CategoryRepository;
import com.estudoDeCaso.shopp.repositories.ProductRepository;
import com.estudoDeCaso.shopp.useCases.stockHistory.CreateStockRegisterUseCase;
import com.estudoDeCaso.shopp.utils.MockProducts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockitoPostProcessor;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CreateProductUseCaseTest {

    @InjectMocks
    private CreateProductUseCase createProductUseCase;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CreateStockRegisterUseCase createStockRegisterUseCase;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute() {
        Product product = MockProducts.mockProduct();
        ProductRequestDto productRequestDto = MockProducts.mockProductRequestDto();

        when(modelMapper.map(productRequestDto, Product.class)).thenReturn(product);
        when(productRepository.existsByNameAndSize(product.getName(),product.getSize())).thenReturn(false);
        when(categoryRepository.existsById(product.getCategory().getId())).thenReturn(true);

        Long productId = createProductUseCase.execute(productRequestDto);

        assertNotNull(product.getCategory());
        assertNotNull(productId);
        verify(productRepository).save(product);
        verify(createStockRegisterUseCase).execute(product);
        assertEquals(product.getId(), productId);

    }

    @Test
    void executeProductAlreadyExists() {
        ProductRequestDto productRequestDto = MockProducts.mockProductRequestDto();
        Product product = MockProducts.mockProduct();

        when(modelMapper.map(productRequestDto, Product.class)).thenReturn(product);
        when(categoryRepository.existsById(product.getCategory().getId())).thenReturn(true);
        when(productRepository.existsByNameAndSize(product.getName(), productRequestDto.getSize())).thenReturn(true);

        assertThrows(AlreadyExistsException.class, () -> createProductUseCase.execute(productRequestDto));
    }


    @Test
    void executeInvalidRequestException(){
        ProductRequestDto productRequestDto = MockProducts.mockProductRequestDto();
        Product product = MockProducts.mockProduct();
        productRequestDto.getCategory().setId(null);

        when(modelMapper.map(productRequestDto, Product.class)).thenReturn(product);
        when(categoryRepository.existsById(product.getCategory().getId())).thenReturn(false);

        assertThrows(InvalidRequestException.class, () -> createProductUseCase.execute(productRequestDto));
    }

}