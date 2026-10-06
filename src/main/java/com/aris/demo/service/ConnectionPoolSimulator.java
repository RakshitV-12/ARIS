package com.aris.demo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Service modeling connection pool utilization and buffer saturation for the Demo Project.
 */
@Service
public class ConnectionPoolSimulator {

    private final AtomicInteger activeConnections = new AtomicInteger(12);
    private final int maxCapacity = 50;

    public int getActiveConnections() {
        return activeConnections.get();
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public double getUtilizationPercent() {
        return (activeConnections.get() * 100.0) / maxCapacity;
    }
}
