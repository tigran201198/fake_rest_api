package net.azurewebservices.fakerestapi.common.utils;

import io.cucumber.java.Scenario;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ScenarioFilter implements Filter {

    private final Scenario scenario;

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
                           FilterContext context) {
        logRequest(requestSpec);
        Response response = context.next(requestSpec, responseSpec);
        logResponse(response);
        return response;
    }

    private void logResponse(Response response) {
        scenario.log("Response:");
        scenario.log("Status: " + response.statusCode());
        scenario.log("Headers: " + response.getHeaders());
        scenario.log("Body: " + response.getBody().asPrettyString());
    }

    private void logRequest(FilterableRequestSpecification requestSpec) {
        scenario.log("Request:");
        scenario.log(requestSpec.getMethod() + " " + requestSpec.getURI());
        scenario.log("Headers: " + requestSpec.getHeaders());
        if (requestSpec.getBody() != null) {
            scenario.log("Body: " + requestSpec.getBody());
        }
    }
}
