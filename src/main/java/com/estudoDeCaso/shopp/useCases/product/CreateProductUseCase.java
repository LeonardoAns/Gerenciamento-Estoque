package com.estudoDeCaso.shopp.useCases.product;

import com.estudoDeCaso.shopp.dto.product.ProductRequestDto;
import com.estudoDeCaso.shopp.entities.Product;
import com.estudoDeCaso.shopp.exceptions.AlreadyExistsException;
import com.estudoDeCaso.shopp.exceptions.InvalidRequestException;
import com.estudoDeCaso.shopp.repositories.CategoryRepository;
import com.estudoDeCaso.shopp.repositories.ProductRepository;
import com.estudoDeCaso.shopp.useCases.stockHistory.CreateStockRegisterUseCase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductUseCase {

    private final ProductRepository productRepository;
    private final CreateStockRegisterUseCase createStockRegisterUseCase;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public Long execute(ProductRequestDto productRequestDto){
        Product product = this.modelMapper.map(productRequestDto, Product.class);
        product.setName(productRequestDto.getName().strip().toLowerCase());

        if (product.getCategory().getId() == null || !this.categoryRepository.existsById(product.getCategory().getId())) {
            throw new InvalidRequestException("Select a valid Category");
        }

        if (this.productRepository.existsByNameAndSize(product.getName(), productRequestDto.getSize())) {
            throw new AlreadyExistsException("Product Already Exists");
        }

        this.productRepository.save(product);
        this.createStockRegisterUseCase.execute(product);

        return product.getId();
    }
}
