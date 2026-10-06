package com.aris.demo.service;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Service simulating real-world latency distributions (p50, p95, p99) and network jitter.
 */
@Service
public class SyntheticTelemetryService {

    private final Random random = new Random();

    public long sampleLatencyMs(boolean injectSpike) {
        if (injectSpike) {
            return 2000L + random.nextInt(1500);
        }
        return 20L + random.nextInt(80);
    }
}
