package org.example.product_service.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products",
        indexes = @Index(name = "idx_products_sku", columnList = "sku"),
        uniqueConstraints = @UniqueConstraint(columnNames = "sku", name = "uq_products_sku"))
public class Product extends BaseEntity {

    @Column(nullable = false, unique = true, length = 64)
    private String sku;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(length = 2000)
    private String description;

    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @Column(length = 120)
    private String brand;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id")
    private Category category;


    public Product(String sku, String name, BigDecimal price, ProductStatus status, Category category) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.status = status;
        this.category = category;
    }
}
