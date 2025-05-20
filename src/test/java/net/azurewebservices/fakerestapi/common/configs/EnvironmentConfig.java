package net.azurewebservices.fakerestapi.common.configs;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("classpath:properties/${env}.properties")
public interface EnvironmentConfig extends Config {
    @Key("base.url")
    String baseUrl();
}
