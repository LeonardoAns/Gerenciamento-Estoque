package com.estudoDeCaso.shopp.useCases.cateogry;


import com.estudoDeCaso.shopp.dto.category.CategoryRequestDto;
import com.estudoDeCaso.shopp.entities.Category;
import com.estudoDeCaso.shopp.exceptions.AlreadyExistsException;
import com.estudoDeCaso.shopp.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequiredArgsConstructor
public class CreateCategoryUseCase {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public Long execute(CategoryRequestDto categoryRequstDto){
        Category category = this.modelMapper.map(categoryRequstDto,Category.class);
        category.setName(categoryRequstDto.getName().strip().toLowerCase());
        if(this.categoryRepository.existsByName(category.getName().strip().toLowerCase())){
            throw new AlreadyExistsException("Category Already Exists");
        }
        this.categoryRepository.save(category);
        return category.getId();
    }
}
