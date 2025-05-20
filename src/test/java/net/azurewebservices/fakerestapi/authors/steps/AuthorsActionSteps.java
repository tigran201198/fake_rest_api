package net.azurewebservices.fakerestapi.authors.steps;

import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import net.azurewebservices.fakerestapi.authors.api.AuthorsClient;
import net.azurewebservices.fakerestapi.authors.entity.AuthorEntity;
import net.azurewebservices.fakerestapi.common.context.TestContext;

import java.util.Objects;

@RequiredArgsConstructor
public class AuthorsActionSteps {

    private final TestContext testContext;
    private final AuthorsClient authorsClient;

    @When("getAllAuthors request is received")
    public void getAllAuthorsRequestIsReceived() {
        testContext.response(authorsClient.getAll());
    }

    @When("getAuthor request is received for the Author")
    public void getAuthorRequestIsReceivedForTheAuthor() {
        AuthorEntity author =
                Objects.requireNonNull(testContext.author(), "an Author should be setup before this step");
        testContext.response(authorsClient.get(author.getId()));
    }

    @When("createAuthor request is received for the Author")
    public void createAuthorRequestIsReceivedForTheAuthor() {
        AuthorEntity author =
                Objects.requireNonNull(testContext.author(), "an Author should be setup before this step");
        testContext.response(authorsClient.create(author));
    }

    @When("deleteAuthor request is received for the Author")
    public void deleteAuthorRequestIsReceivedForTheAuthor() {
        AuthorEntity author =
                Objects.requireNonNull(testContext.author(), "an Author should be setup before this step");
        testContext.response(authorsClient.delete(author.getId()));
    }

    @When("updateAuthor request is received for the Author")
    public void updateAuthorRequestIsReceivedForTheAuthor() {
        AuthorEntity author =
                Objects.requireNonNull(testContext.author(), "an Author should be setup before this step");
        testContext.response(authorsClient.update(author, author.getId()));
    }
}
