package net.azurewebservices.fakerestapi.common.assertion;

import net.azurewebservices.fakerestapi.common.entity.ErrorEntity;
import net.azurewebservices.fakerestapi.common.enums.ErrorType;
import org.assertj.core.api.SoftAssertions;

public class ErrorEntityAsserter {

    public void assertError(ErrorType errorType, ErrorEntity error) {
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(error.getType()).isNotEmpty();
        assertions.assertThat(error.getTitle()).isEqualTo(errorType.getTitle());
        assertions.assertThat(error.getStatus()).isEqualTo(errorType.getStatus());
        assertions.assertThat(error.getTraceId()).isNotEmpty();
        if (errorType.isHasErrors()) {
            assertions.assertThat(error.getErrors()).isNotEmpty();
        } else {
            assertions.assertThat(error.getErrors()).isNullOrEmpty();
        }
        assertions.assertAll();
    }
}
