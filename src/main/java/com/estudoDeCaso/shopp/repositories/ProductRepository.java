package com.estudoDeCaso.shopp.repositories;

import com.estudoDeCaso.shopp.entities.Product;
import com.estudoDeCaso.shopp.entities.enums.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByNameAndSize(String name, Size size);
    Optional<Product> findProductByNameAndSize(String name, Size size);
    Optional<Product> findProductByName(String name);

}
