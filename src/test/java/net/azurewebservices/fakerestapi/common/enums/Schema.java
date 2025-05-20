package net.azurewebservices.fakerestapi.common.enums;

public enum Schema {

    MULTIPLE_AUTHORS,
    SINGLE_AUTHOR,

    MULTIPLE_BOOKS,
    SINGLE_BOOK,
    ERROR;

    public String getSchemaFilePath() {
        return "schemas/%s.json".formatted(this.name().toLowerCase());
    }
}
