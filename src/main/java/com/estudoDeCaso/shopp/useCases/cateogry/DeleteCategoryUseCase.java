package com.estudoDeCaso.shopp.useCases.cateogry;

import com.estudoDeCaso.shopp.entities.Category;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCategoryUseCase {

    private final CategoryRepository categoryRepository;

    public void execute(Long id){
        Category category = this.categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category Not Found"));
        this.categoryRepository.delete(category);

    }
}
