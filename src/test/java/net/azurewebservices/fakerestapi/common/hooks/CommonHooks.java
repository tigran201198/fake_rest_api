package net.azurewebservices.fakerestapi.common.hooks;


import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.RequiredArgsConstructor;
import net.azurewebservices.fakerestapi.common.context.ScenarioContext;

@RequiredArgsConstructor
public class CommonHooks {

    private final ScenarioContext scenarioContext;

    @Before
    public void before(Scenario scenario) {
        scenarioContext.scenario(scenario);
    }
}
