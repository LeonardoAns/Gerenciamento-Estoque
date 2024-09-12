package com.estudoDeCaso.shopp.useCases.cateogry;

import com.estudoDeCaso.shopp.dto.category.CategoryResponseDto;
import com.estudoDeCaso.shopp.entities.Category;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindCategoryByIdUseCase {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryResponseDto execute(Long id){
        Category category = this.categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Cateogry Not Found"));
        return this.modelMapper.map(category, CategoryResponseDto.class);
    }
}
