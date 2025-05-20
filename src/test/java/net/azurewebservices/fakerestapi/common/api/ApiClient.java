package net.azurewebservices.fakerestapi.common.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;
import net.azurewebservices.fakerestapi.common.context.ScenarioContext;
import net.azurewebservices.fakerestapi.common.utils.EnvironmentProperties;
import net.azurewebservices.fakerestapi.common.utils.ScenarioFilter;

import static net.azurewebservices.fakerestapi.common.urls.ApiUrls.BASE_PATH;
import static net.azurewebservices.fakerestapi.common.urls.ApiUrls.ID_PATH;
import static org.apache.http.entity.ContentType.APPLICATION_JSON;

@RequiredArgsConstructor
public class ApiClient<T> {

    private static final RestAssuredConfig OBJECT_MAPPER_CONFIG =
            RestAssuredConfig.config().objectMapperConfig(
                    new ObjectMapperConfig().jackson2ObjectMapperFactory((type, s) -> new ObjectMapper()
                            .findAndRegisterModules().registerModule(new JavaTimeModule())
                            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS))
            );

    private final ScenarioContext scenarioContext;
    private final String resourcePath;

    public Response getAll() {
        return baseRequest().get(resourcePath);
    }

    public Response get(Object id) {
        return baseRequest().get(resourcePath + ID_PATH, id);
    }

    public Response delete(Object id) {
        return baseRequest().delete(resourcePath + ID_PATH, id);
    }

    public Response create(T entity) {
        return baseRequest()
                .body(entity)
                .post(resourcePath);
    }

    public Response update(T entity, Object id) {
        return baseRequest()
                .body(entity)
                .put(resourcePath + ID_PATH, id);
    }

    private RequestSpecification baseRequest() {
        return RestAssured.given()
                .baseUri(EnvironmentProperties.URLS_CONFIG.baseUrl())
                .basePath(BASE_PATH)
                .config(OBJECT_MAPPER_CONFIG)
                .filter(new ScenarioFilter(scenarioContext.scenario()))
                .contentType(APPLICATION_JSON.getMimeType());
    }
}
