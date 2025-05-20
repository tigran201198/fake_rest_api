package net.azurewebservices.fakerestapi.books.setup;

import lombok.experimental.UtilityClass;
import net.azurewebservices.fakerestapi.books.entity.BookEntity;
import net.azurewebservices.fakerestapi.common.utils.ReflectionUtils;

import java.time.OffsetDateTime;

import static net.azurewebservices.fakerestapi.common.utils.RandomUtils.randomAlphabeticString;
import static net.azurewebservices.fakerestapi.common.utils.RandomUtils.randomInt;

@UtilityClass
public class BookTestDataSetup {

    public static BookEntity defaultBook() {
        return new BookEntity(
                randomInt(),
                randomAlphabeticString(10),
                randomAlphabeticString(20),
                randomInt(),
                randomAlphabeticString(30),
                OffsetDateTime.now()
        );
    }

    public static BookEntity bookWithNullForField(String fieldName) {
        BookEntity book = defaultBook();
        ReflectionUtils.setNullProperty(book, fieldName);
        return book;
    }
}
