package net.azurewebservices.fakerestapi.books.assertions;

import net.azurewebservices.fakerestapi.books.entity.BookEntity;
import org.assertj.core.api.SoftAssertions;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class BookAsserter {

    public void assertBooks(BookEntity actualBook, BookEntity expectedBook) {
        SoftAssertions assertions = new SoftAssertions();
        assertThat(actualBook.getTitle()).isEqualTo(expectedBook.getTitle());
        assertThat(actualBook.getDescription()).isEqualTo(expectedBook.getDescription());
        assertThat(actualBook.getId()).isEqualTo(expectedBook.getId());
        assertThat(actualBook.getPageCount()).isEqualTo(expectedBook.getPageCount());
        assertThat(actualBook.getExcerpt()).isEqualTo(expectedBook.getExcerpt());
        assertThat(toInstant(actualBook)).isEqualTo(toInstant(expectedBook));
        assertions.assertAll();
    }

    private Instant toInstant(BookEntity actualBook) {
        return actualBook.getPublishDate().toInstant().truncatedTo(ChronoUnit.SECONDS);
    }
}
