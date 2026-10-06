package com.aris.demo;

import com.aris.common.ApiResponse;
import com.aris.demo.model.SystemHealthReport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.util.Map;

/**
 * Health verification endpoint for the "Demo Project":
 * Reports runtime uptime, thread status, and JVM health diagnostic indicators.
 */
@RestController
public class DemoHealthController {

    private final long startTime = System.currentTimeMillis();

    @GetMapping("/api/health")
    public ApiResponse<SystemHealthReport> health() {
        long uptime = (System.currentTimeMillis() - startTime) / 1000;
        int activeThreads = ManagementFactory.getThreadMXBean().getThreadCount();
        long freeMem = Runtime.getRuntime().freeMemory() / (1024 * 1024);
        long totalMem = Runtime.getRuntime().totalMemory() / (1024 * 1024);

        SystemHealthReport report = new SystemHealthReport(
                "UP (200 OK)",
                uptime,
                activeThreads,
                freeMem,
                totalMem,
                "Demo telemetry health checks passing with normal jitter"
        );

        return new ApiResponse<>(true, "ARIS Demo Service is healthy", report);
    }
}
