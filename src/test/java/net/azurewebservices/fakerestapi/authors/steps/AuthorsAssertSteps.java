package net.azurewebservices.fakerestapi.authors.steps;

import io.cucumber.java.en.Then;
import io.restassured.common.mapper.TypeRef;
import lombok.RequiredArgsConstructor;
import net.azurewebservices.fakerestapi.authors.entity.AuthorEntity;
import net.azurewebservices.fakerestapi.common.context.TestContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class AuthorsAssertSteps {

    private final TestContext testContext;

    @Then("API returns Author details")
    public void apiReturnsAuthorDetails() {
        AuthorEntity actualAuthor = testContext.response().body().as(AuthorEntity.class);
        AuthorEntity expectedAuthor = testContext.author();
        assertThat(actualAuthor).isEqualTo(expectedAuthor);
    }

    @Then("API returns Authors details")
    public void apiReturnsAuthorsDetails() {
        List<AuthorEntity> actualAuthors = testContext.response().as(new TypeRef<>() {
        });
        List<AuthorEntity> expectedAuthors = testContext.authors();
        assertThat(actualAuthors).containsExactlyInAnyOrderElementsOf(expectedAuthors);
    }
}
