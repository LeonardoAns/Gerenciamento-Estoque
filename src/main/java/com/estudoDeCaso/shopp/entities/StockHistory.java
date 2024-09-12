package com.estudoDeCaso.shopp.entities;

import com.estudoDeCaso.shopp.entities.enums.ChangeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantityChange;

    @Enumerated(EnumType.STRING)
    private ChangeType changeType;

    @CreationTimestamp
    private LocalDateTime changeDate;

}
