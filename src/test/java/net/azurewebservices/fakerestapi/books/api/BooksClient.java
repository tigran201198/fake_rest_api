package net.azurewebservices.fakerestapi.books.api;

import net.azurewebservices.fakerestapi.books.entity.BookEntity;
import net.azurewebservices.fakerestapi.common.api.ApiClient;
import net.azurewebservices.fakerestapi.common.context.ScenarioContext;

import static net.azurewebservices.fakerestapi.common.urls.ApiUrls.BOOKS_PATH;

public class BooksClient extends ApiClient<BookEntity> {

    public BooksClient(ScenarioContext scenarioContext) {
        super(scenarioContext, BOOKS_PATH);
    }
}
