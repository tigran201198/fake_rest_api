package net.azurewebservices.fakerestapi.common.context;

import io.cucumber.java.Scenario;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
public class ScenarioContext {

    private Scenario scenario;
}
