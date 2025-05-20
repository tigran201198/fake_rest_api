package net.azurewebservices.fakerestapi.books.steps;

import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import net.azurewebservices.fakerestapi.books.api.BooksClient;
import net.azurewebservices.fakerestapi.books.entity.BookEntity;
import net.azurewebservices.fakerestapi.common.context.TestContext;

import java.util.Objects;

@RequiredArgsConstructor
public class BooksActionSteps {

    private final TestContext testContext;
    private final BooksClient booksClient;

    @When("getAllBooks request is received")
    public void getAllBooksRequestIsReceived() {
        testContext.response(booksClient.getAll());
    }

    @When("getBook request is received for the Book")
    public void getBookRequestIsReceivedForTheBook() {
        BookEntity book =
                Objects.requireNonNull(testContext.book(), "a Book should be setup before this step");
        testContext.response(booksClient.get(book.getId()));
    }

    @When("createBook request is received for the Book")
    public void createBookRequestIsReceivedForTheBook() {
        BookEntity book =
                Objects.requireNonNull(testContext.book(), "a Book should be setup before this step");
        testContext.response(booksClient.create(book));
    }

    @When("deleteBook request is received for the Book")
    public void deleteBookRequestIsReceivedForTheBook() {
        BookEntity book =
                Objects.requireNonNull(testContext.book(), "a Book should be setup before this step");
        testContext.response(booksClient.delete(book.getId()));
    }

    @When("updateBook request is received for the Book")
    public void updateBookRequestIsReceivedForTheBook() {
        BookEntity book =
                Objects.requireNonNull(testContext.book(), "a Book should be setup before this step");
        testContext.response(booksClient.update(book, book.getId()));
    }
}
