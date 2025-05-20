Feature: Create Author - sad paths

  Scenario Outline: an Author with mandatory fields missing cannot be created
    Given an Author without <field> field was not added to API yet
    When createAuthor request is received for the Author
    Then the response status code is 400
    And the response matches 'ERROR' schema
    And API returns VALIDATION error
    Examples:
      | field  |
      | id     |
      | idBook |
