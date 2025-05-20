package net.azurewebservices.fakerestapi.authors.steps;

import io.cucumber.java.en.Given;
import io.restassured.common.mapper.TypeRef;
import lombok.RequiredArgsConstructor;
import net.azurewebservices.fakerestapi.authors.api.AuthorsClient;
import net.azurewebservices.fakerestapi.authors.entity.AuthorEntity;
import net.azurewebservices.fakerestapi.authors.setup.AuthorTestDataSetup;
import net.azurewebservices.fakerestapi.common.context.TestContext;
import net.azurewebservices.fakerestapi.common.utils.RandomUtils;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class AuthorsSetupSteps {

    private final TestContext testContext;
    private final AuthorsClient authorsClient;

    @Given("an Author was not added to API yet")
    public void anAuthorWasNotAddedToApiYet() {
        testContext.author(AuthorTestDataSetup.defaultAuthor());
    }

    @Given("an Author without {} field was not added to API yet")
    public void anAuthorWithoutFieldWasNotAddedToApiYet(String fieldName) {
        testContext.author(AuthorTestDataSetup.authorWithNullForField(fieldName));
    }

    @Given("an Author is present in API")
    public void anAuthorIsPresentInApi() {
        List<AuthorEntity> authors = authorsClient.getAll().as(new TypeRef<>() {
        });
        testContext.author(authors.get(RandomUtils.randomCollectionIndex(authors.size())));
    }

    @Given("Authors are present in API")
    public void authorsArePresentInApi() {
        testContext.authors(authorsClient.getAll().as(new TypeRef<>() {
        }));
    }

    @Given("the Author was updated but not added to API yet")
    public void theAuthorWasUpdatedButNotAddedToApiYet() {
        AuthorEntity author =
                Objects.requireNonNull(testContext.author(), "an Author should be setup before this step");
        int id = author.getId();
        testContext.author(AuthorTestDataSetup.defaultAuthor());
        testContext.author().setId(id);
    }

    @Given("the Author without {} field was updated but not added to API yet")
    public void theAuthorWithoutFieldWasUpdatedButNotAddedToApiYet(String fieldName) {
        AuthorEntity author =
                Objects.requireNonNull(testContext.author(), "an Author should be setup before this step");
        int id = author.getId();
        testContext.author(AuthorTestDataSetup.authorWithNullForField(fieldName));
        testContext.author().setId(id);
    }
}
