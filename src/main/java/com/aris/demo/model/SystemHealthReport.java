package com.aris.demo.model;

/**
 * Health diagnostic metrics report model for the Demo Project.
 */
public record SystemHealthReport(
        String status,
        long uptimeSeconds,
        int activeThreads,
        long freeMemoryMb,
        long totalMemoryMb,
        String message
) {}
