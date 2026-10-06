package com.aris.ecom.service;

import com.aris.ecom.model.ProductItem;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service managing product inventory lookup, SKU pricing, and stock checks.
 */
@Service
public class ProductCatalogService {

    private final List<ProductItem> catalog = List.of(
            new ProductItem(1L, "SKU-HEADPHONES-PRO", "Noise-Cancelling Headphones", 249.99, 120, "audio"),
            new ProductItem(2L, "SKU-MONITOR-4K", "Ultra-Wide 4K Gaming Monitor", 599.00, 35, "displays"),
            new ProductItem(3L, "SKU-KEYBOARD-MECH", "Low-Profile Wireless Keyboard", 129.50, 85, "accessories")
    );

    public List<ProductItem> listCatalog() {
        return catalog;
    }

    public int totalStock() {
        return catalog.stream().mapToInt(ProductItem::stockQuantity).sum();
    }
}
