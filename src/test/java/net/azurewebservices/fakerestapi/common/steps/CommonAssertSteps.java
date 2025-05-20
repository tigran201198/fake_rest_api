package net.azurewebservices.fakerestapi.common.steps;

import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import lombok.RequiredArgsConstructor;
import net.azurewebservices.fakerestapi.common.assertion.ErrorEntityAsserter;
import net.azurewebservices.fakerestapi.common.context.TestContext;
import net.azurewebservices.fakerestapi.common.entity.ErrorEntity;
import net.azurewebservices.fakerestapi.common.enums.ErrorType;
import net.azurewebservices.fakerestapi.common.enums.Schema;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class CommonAssertSteps {

    private final TestContext testContext;
    private final ErrorEntityAsserter errorEntityAsserter;

    @Then("the response status code is {int}")
    public void theResponseStatusCodeIs(int expectedStatusCode) {
        assertThat(testContext.response().statusCode()).isEqualTo(expectedStatusCode);
    }

    @Then("the response matches '{}' schema")
    public void theResponseMatchesSchema(Schema schema) {
        testContext.response().then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schema.getSchemaFilePath()));
    }

    @Then("API returns {} error")
    public void apiReturnsError(ErrorType errorType) {
        ErrorEntity error = testContext.response().body().as(ErrorEntity.class);
        errorEntityAsserter.assertError(errorType, error);
    }

    @Then("API returns empty response")
    public void apiReturnsEmptyResponse() {
        assertThat(testContext.response().body().asString()).isEmpty();
    }
}
