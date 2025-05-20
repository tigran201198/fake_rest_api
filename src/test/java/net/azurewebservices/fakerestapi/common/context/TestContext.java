package net.azurewebservices.fakerestapi.common.context;

import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.azurewebservices.fakerestapi.authors.entity.AuthorEntity;
import net.azurewebservices.fakerestapi.books.entity.BookEntity;

import java.util.List;

@Getter
@Setter
@Accessors(fluent = true)
public class TestContext {

    private AuthorEntity author;
    private List<AuthorEntity> authors;
    private BookEntity book;
    private List<BookEntity> books;
    private Response response;
}
