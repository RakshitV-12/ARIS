package com.aris.ecom.model;

import java.util.List;

/**
 * Domain entity model representing a customer shopping cart order.
 */
public record CustomerOrder(
        String orderId,
        String customerEmail,
        List<ProductItem> items,
        double orderTotal,
        String fulfillmentStatus
) {}
