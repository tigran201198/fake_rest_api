Feature: Create Author - happy paths

  Scenario: an Author with all fields setup can be created
    Given an Author was not added to API yet
    When createAuthor request is received for the Author
    Then the response status code is 200
    And the response matches 'SINGLE_AUTHOR' schema
    And API returns Author details

  Scenario Outline: an Author with optional fields missing can be created
    Given an Author without <field> field was not added to API yet
    When createAuthor request is received for the Author
    Then the response status code is 200
    And the response matches 'SINGLE_AUTHOR' schema
    And API returns Author details
    Examples:
      | field     |
      | firstName |
      | lastName  |
