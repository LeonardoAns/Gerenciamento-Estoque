package com.estudoDeCaso.shopp.useCases.cateogry;

import com.estudoDeCaso.shopp.dto.category.CategoryResponseDto;
import com.estudoDeCaso.shopp.entities.Category;
import com.estudoDeCaso.shopp.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindAllCategoriesUseCase {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public List<CategoryResponseDto> execute(){
        List<Category> categories = this.categoryRepository.findAll();
        return categories
                .stream()
                .map(category ->
                        this.modelMapper.map(category, CategoryResponseDto.class))
                .collect(Collectors.toList());
    }
}
