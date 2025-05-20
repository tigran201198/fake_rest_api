Feature: Get Author - sad paths

  Scenario: a not existing Author cannot be get
    Given an Author was not added to API yet
    When getAuthor request is received for the Author
    Then the response status code is 404
    And the response matches 'ERROR' schema
    And API returns NOT_FOUND error
