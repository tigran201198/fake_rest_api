Feature: Update Author - happy paths

  Scenario: an Author with all fields setup can be updated
    Given an Author is present in API
    And the Author was updated but not added to API yet
    When updateAuthor request is received for the Author
    Then the response status code is 200
    And the response matches 'SINGLE_AUTHOR' schema
    And API returns Author details

  Scenario Outline: an Author with optional fields missing can be updated
    Given an Author is present in API
    And the Author without <field> field was updated but not added to API yet
    When updateAuthor request is received for the Author
    Then the response status code is 200
    And the response matches 'SINGLE_AUTHOR' schema
    And API returns Author details
    Examples:
      | field     |
      | firstName |
      | lastName  |
