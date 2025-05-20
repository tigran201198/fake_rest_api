package net.azurewebservices.fakerestapi.test;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.ConfigurationParameters;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@SelectClasspathResource("features")
@ConfigurationParameters({
        @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "net.azurewebservices.fakerestapi"),
        @ConfigurationParameter(key = PARALLEL_EXECUTION_ENABLED_PROPERTY_NAME, value = "true"),
        @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "json:build/cucumber-report/json/cucumber-report.json")
})
public class TestRunner {
}