package net.azurewebservices.fakerestapi.books.steps;

import io.cucumber.java.en.Then;
import io.restassured.common.mapper.TypeRef;
import lombok.RequiredArgsConstructor;
import net.azurewebservices.fakerestapi.books.assertions.BookAsserter;
import net.azurewebservices.fakerestapi.books.entity.BookEntity;
import net.azurewebservices.fakerestapi.common.context.TestContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class BooksAssertSteps {

    private final TestContext testContext;
    private final BookAsserter bookAsserter;

    @Then("API returns Book details")
    public void apiReturnsBookDetails() {
        BookEntity actualBook = testContext.response().body().as(BookEntity.class);
        BookEntity expectedBook = testContext.book();
        bookAsserter.assertBooks(actualBook, expectedBook);
    }

    @Then("API returns Books details")
    public void apiReturnsBooksDetails() {
        List<BookEntity> actualBooks = testContext.response().as(new TypeRef<>() {
        });
        List<BookEntity> expectedBooks = testContext.books();
        assertThat(actualBooks).isEqualTo(expectedBooks);
    }
}
