package net.azurewebservices.fakerestapi.books.steps;

import io.cucumber.java.en.Given;
import io.restassured.common.mapper.TypeRef;
import lombok.RequiredArgsConstructor;
import net.azurewebservices.fakerestapi.books.api.BooksClient;
import net.azurewebservices.fakerestapi.books.entity.BookEntity;
import net.azurewebservices.fakerestapi.books.setup.BookTestDataSetup;
import net.azurewebservices.fakerestapi.common.context.TestContext;
import net.azurewebservices.fakerestapi.common.utils.RandomUtils;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class BooksSetupSteps {

    private final TestContext testContext;
    private final BooksClient booksClient;

    @Given("a Book was not added to API yet")
    public void aBookWasNotAddedToApiYet() {
        testContext.book(BookTestDataSetup.defaultBook());
    }

    @Given("a Book without {} field was not added to API yet")
    public void aBookWithoutFieldWasNotAddedToApiYet(String fieldName) {
        testContext.book(BookTestDataSetup.bookWithNullForField(fieldName));
    }

    @Given("a Book is present in API")
    public void aBookIsPresentInApi() {
        List<BookEntity> books = booksClient.getAll().as(new TypeRef<>() {
        });
        testContext.book(books.get(RandomUtils.randomCollectionIndex(books.size())));
    }

    @Given("Books are present in API")
    public void booksArePresentInApi() {
        testContext.books(booksClient.getAll().as(new TypeRef<>() {
        }));
    }

    @Given("the Book was updated but not added to API yet")
    public void theBookWasUpdatedButNotAddedToApiYet() {
        BookEntity book =
                Objects.requireNonNull(testContext.book(), "a Book should be setup before this step");
        int id = book.getId();
        testContext.book(BookTestDataSetup.defaultBook());
        testContext.book().setId(id);
    }

    @Given("the Book without {} field was updated but not added to API yet")
    public void theBookWithoutFieldWasUpdatedButNotAddedToApiYet(String fieldName) {
        BookEntity book =
                Objects.requireNonNull(testContext.book(), "a Book should be setup before this step");
        int id = book.getId();
        testContext.book(BookTestDataSetup.bookWithNullForField(fieldName));
        testContext.book().setId(id);
    }
}
