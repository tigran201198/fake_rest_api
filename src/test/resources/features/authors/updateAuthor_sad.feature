Feature: Update Author - sad paths

  Scenario: an Author with required fields missing cannot be updated
    Given an Author is present in API
    And the Author without idBook field was updated but not added to API yet
    When updateAuthor request is received for the Author
    Then the response status code is 400
    And the response matches 'ERROR' schema
    And API returns VALIDATION error

  Scenario: a not existing Author cannot be updated
    Given an Author was not added to API yet
    When updateAuthor request is received for the Author
    Then the response status code is 404
    And the response matches 'ERROR' schema
    And API returns NOT_FOUND error
