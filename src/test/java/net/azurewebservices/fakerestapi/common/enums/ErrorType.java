package net.azurewebservices.fakerestapi.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;

@RequiredArgsConstructor
@Getter
public enum ErrorType {

    VALIDATION("One or more validation errors occurred.", SC_BAD_REQUEST, TRUE),
    NOT_FOUND("Not Found", SC_NOT_FOUND, FALSE);

    private final String title;
    private final int status;
    private final boolean hasErrors;
}
