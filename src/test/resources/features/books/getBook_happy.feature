Feature: Get Book - happy paths

  Scenario: an existing Book can be get
    Given a Book is present in API
    When getBook request is received for the Book
    Then the response status code is 200
    And the response matches 'SINGLE_BOOK' schema
    And API returns Book details
