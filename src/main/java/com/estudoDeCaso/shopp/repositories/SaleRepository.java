package com.estudoDeCaso.shopp.repositories;

import com.estudoDeCaso.shopp.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findSalesByEmployeeId(Long id);

}
