package net.azurewebservices.fakerestapi.common.utils;

import lombok.experimental.UtilityClass;
import net.azurewebservices.fakerestapi.common.configs.EnvironmentConfig;
import net.azurewebservices.fakerestapi.common.enums.Environment;
import org.aeonbits.owner.ConfigFactory;

import java.util.Optional;

@UtilityClass
public class EnvironmentProperties {

    private static final String ENV_PROPERTY_NAME = "env";

    public static final EnvironmentConfig URLS_CONFIG;

    static {
        String env = Optional.ofNullable(System.getenv(ENV_PROPERTY_NAME)).orElse(Environment.REMOTE.name());
        System.setProperty(ENV_PROPERTY_NAME, Environment.findEnvironment(env).name().toLowerCase());
        URLS_CONFIG = ConfigFactory.create(EnvironmentConfig.class);
    }
}
