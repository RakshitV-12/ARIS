package com.aris.ecom.model;

/**
 * Domain entity model representing an e-commerce catalog product item.
 */
public record ProductItem(
        Long id,
        String sku,
        String title,
        double price,
        int stockQuantity,
        String category
) {}
