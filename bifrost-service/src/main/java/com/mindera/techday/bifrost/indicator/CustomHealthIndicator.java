package com.mindera.techday.bifrost.indicator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class CustomHealthIndicator implements HealthIndicator {

    private String statusMessage;

    public CustomHealthIndicator(@Value("${message}") String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @Override
    public Health health() {
        return Health.status(statusMessage).build();
    }
}
