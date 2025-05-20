Feature: Update Book - happy paths

  Scenario: a Book with all fields setup can be updated
    Given a Book is present in API
    And the Book was updated but not added to API yet
    When updateBook request is received for the Book
    Then the response status code is 200
    And the response matches 'SINGLE_BOOK' schema
    And API returns Book details

  Scenario Outline: a Book with optional fields missing can be updated
    Given a Book is present in API
    And the Book without <field> field was updated but not added to API yet
    When updateBook request is received for the Book
    Then the response status code is 200
    And the response matches 'SINGLE_BOOK' schema
    And API returns Book details
    Examples:
      | field       |
      | title       |
      | description |
      | excerpt     |
