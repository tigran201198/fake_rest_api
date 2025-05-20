Feature: Create Book - sad paths

  Scenario Outline: a Book with mandatory fields missing cannot be created
    Given a Book without <field> field was not added to API yet
    When createBook request is received for the Book
    Then the response status code is 400
    And the response matches 'ERROR' schema
    And API returns VALIDATION error
    Examples:
      | field       |
      | id          |
      | pageCount   |
      | publishDate |
