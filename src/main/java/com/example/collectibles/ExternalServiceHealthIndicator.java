package com.example.collectibles;

import java.util.List;
import java.util.Random;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ExternalServiceHealthIndicator implements HealthIndicator {

    private final Random randomizer = new Random();
    private final List<Integer> statusCodes = List.of(200, 204, 401, 404, 503);

    @Override
    public Health health() {
        int randomStatusCode = statusCodes.get(randomizer.nextInt(statusCodes.size()));
        Health.Builder healthBuilder = new Health.Builder();
        return (switch(randomStatusCode) {
            case 200, 204 -> healthBuilder.up()
                    .withDetail("Bigstart", "Service is Up and Running ✅")
                    .withDetail("url", "http://10.105.136.231:80");
            case 503 -> healthBuilder.down()
                    .withDetail("Bigstart", "Service is Down 🔻")
                    .withDetail("alternative_url", "http://10.105.136.231:80");
            default -> healthBuilder.unknown().withException(new RuntimeException("Received status: " + randomStatusCode));
        }).build();
    }
}
