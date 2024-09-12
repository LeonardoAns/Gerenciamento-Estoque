package com.estudoDeCaso.shopp.repositories;

import com.estudoDeCaso.shopp.entities.Category;
import com.estudoDeCaso.shopp.entities.enums.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);

}
