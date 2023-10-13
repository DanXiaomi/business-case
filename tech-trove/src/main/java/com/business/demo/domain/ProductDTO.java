package com.business.demo.domain;

import com.business.demo.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotBlank(message = "code is required")
    private String code;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "brand is required")
    private String brand;

    @NotNull(message = "price is required")
    private BigDecimal price;

    @NotNull(message = "category is requiered")
    private Category category;

    @NotNull(message = "stock is required")
    private Integer stock;
}
