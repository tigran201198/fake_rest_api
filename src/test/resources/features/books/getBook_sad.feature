Feature: Get Book - sad paths

  Scenario: a not existing Book cannot be get
    Given a Book was not added to API yet
    When getBook request is received for the Book
    Then the response status code is 404
    And the response matches 'ERROR' schema
    And API returns NOT_FOUND error
