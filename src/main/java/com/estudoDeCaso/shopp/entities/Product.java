package com.estudoDeCaso.shopp.entities;

import com.estudoDeCaso.shopp.entities.Category;
import com.estudoDeCaso.shopp.entities.Sale;
import com.estudoDeCaso.shopp.entities.StockHistory;
import com.estudoDeCaso.shopp.entities.enums.Size;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name field is empty")
    private String name;

    @NotNull(message = "Size field is empty")
    @Enumerated(EnumType.STRING)
    private Size size;

    @NotNull(message = "Price field is empty")
    private Double price;

    @NotNull(message = "Quantity field is empty")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull(message = "Select a category")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StockHistory> stockHistory = new ArrayList<>();

    @ManyToMany(mappedBy = "productList")
    private List<Sale> sales = new ArrayList<>();

    public Product(Long id, String name, Size size, Double price, Integer quantity, Category category) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }
}
