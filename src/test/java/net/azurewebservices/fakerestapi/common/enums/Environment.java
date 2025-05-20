package net.azurewebservices.fakerestapi.common.enums;

import java.util.Arrays;

public enum Environment {
    LOCAL,
    REMOTE;

    public static Environment findEnvironment(String systemEvn) {
        return Arrays.stream(Environment.values())
                .filter(environment -> environment.name().equalsIgnoreCase(systemEvn))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Environment not found for: " + systemEvn));
    }
}
