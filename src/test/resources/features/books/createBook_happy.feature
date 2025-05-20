Feature: Create Book - happy paths

  Scenario: a Book with all fields setup can be created
    Given a Book was not added to API yet
    When createBook request is received for the Book
    Then the response status code is 200
    And the response matches 'SINGLE_BOOK' schema
    And API returns Book details

  Scenario Outline: a Book with optional fields missing can be created
    Given a Book without <field> field was not added to API yet
    When createBook request is received for the Book
    Then the response status code is 200
    And the response matches 'SINGLE_BOOK' schema
    And API returns Book details
    Examples:
      | field       |
      | title       |
      | description |
      | excerpt     |
