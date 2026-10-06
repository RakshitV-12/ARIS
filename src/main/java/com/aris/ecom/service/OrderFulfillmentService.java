package com.aris.ecom.service;

import com.aris.ecom.model.CustomerOrder;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Service managing order queue ingestion, warehouse routing, and dispatch statuses.
 */
@Service
public class OrderFulfillmentService {

    private final AtomicInteger processedOrders = new AtomicInteger(142);
    private final AtomicInteger pendingQueue = new AtomicInteger(8);

    public int getProcessedCount() {
        return processedOrders.get();
    }

    public int getPendingQueueSize() {
        return pendingQueue.get();
    }

    public void processOrder(CustomerOrder order) {
        processedOrders.incrementAndGet();
    }
}
