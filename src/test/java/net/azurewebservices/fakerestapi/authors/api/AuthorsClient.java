package net.azurewebservices.fakerestapi.authors.api;

import net.azurewebservices.fakerestapi.authors.entity.AuthorEntity;
import net.azurewebservices.fakerestapi.common.api.ApiClient;
import net.azurewebservices.fakerestapi.common.context.ScenarioContext;

import static net.azurewebservices.fakerestapi.common.urls.ApiUrls.AUTHORS_PATH;

public class AuthorsClient extends ApiClient<AuthorEntity> {

    public AuthorsClient(ScenarioContext scenarioContext) {
        super(scenarioContext, AUTHORS_PATH);
    }
}
