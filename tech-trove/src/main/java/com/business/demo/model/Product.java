package com.business.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Product {

    @Id
    private String id;

    @Indexed(unique = true)
    private String code;

    private String name;

    private String brand;

    private BigDecimal price;

    private Category category;

    private Integer stock;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
