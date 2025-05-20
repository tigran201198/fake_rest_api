package net.azurewebservices.fakerestapi.authors.setup;

import lombok.experimental.UtilityClass;
import net.azurewebservices.fakerestapi.authors.entity.AuthorEntity;
import net.azurewebservices.fakerestapi.common.utils.ReflectionUtils;

import static net.azurewebservices.fakerestapi.common.utils.RandomUtils.randomAlphabeticString;
import static net.azurewebservices.fakerestapi.common.utils.RandomUtils.randomInt;

@UtilityClass
public class AuthorTestDataSetup {

    public static AuthorEntity defaultAuthor() {
        return new AuthorEntity(
                randomInt(),
                randomInt(),
                randomAlphabeticString(10),
                randomAlphabeticString(20)
        );
    }

    public static AuthorEntity authorWithNullForField(String fieldName) {
        AuthorEntity author = defaultAuthor();
        ReflectionUtils.setNullProperty(author, fieldName);
        return author;
    }
}
