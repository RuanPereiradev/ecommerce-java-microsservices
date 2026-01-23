package com.alibou.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,

        @NotNull(message = "Product name is required")
        String name,

        @NotNull(message = "Product description is required")
        String description,

        @Positive(message = "Available quantity must be positive")
        double availableQuantity,

        @Positive(message = "price must be positive")
        BigDecimal price,

        @NotNull(message = "Category ID is required")
        Integer categoryId
) {

}
