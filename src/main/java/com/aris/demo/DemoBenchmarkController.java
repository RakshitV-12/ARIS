package com.aris.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;

/**
 * Synthetic telemetry benchmark endpoints for the "Demo Project":
 * - /api/demo/slow: Latency spike simulation with synthetic database delay
 * - /api/demo/flaky: Intermittent DB connection pool exhaustion failure
 */
@RestController
public class DemoBenchmarkController {

    private final Random rnd = new Random();

    @GetMapping("/api/demo/slow")
    public Map<String, Object> slow() throws InterruptedException {
        Thread.sleep(rnd.nextInt(100) < 15 ? 2500 + rnd.nextInt(1000) : 100 + rnd.nextInt(200));
        return Map.of(
                "status", "ok",
                "benchmark", "synthetic_latency_probe",
                "timestamp", System.currentTimeMillis()
        );
    }

    @GetMapping("/api/demo/flaky")
    public Map<String, Object> flaky() {
        if (rnd.nextInt(100) < 30) {
            throw new IllegalStateException("Simulated DB connection pool exhausted: 0 of 50 connections available");
        }
        return Map.of(
                "status", "ok",
                "activeConnections", 18,
                "poolCapacity", 50,
                "health", "OPTIMAL"
        );
    }
}
