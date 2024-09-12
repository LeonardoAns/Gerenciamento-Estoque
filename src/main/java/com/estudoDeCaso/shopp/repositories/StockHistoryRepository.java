package com.estudoDeCaso.shopp.repositories;

import com.estudoDeCaso.shopp.entities.StockHistory;
import com.estudoDeCaso.shopp.entities.enums.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface StockHistoryRepository extends JpaRepository<StockHistory, Long> {
    List<StockHistory> findStockHistoryByProductId(Long id);
    List<StockHistory> findStockHistoryByDate(LocalDateTime initialDate, LocalDateTime finalDate);
}
