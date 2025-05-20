Feature: Get Author - happy paths

  Scenario: an existing Author can be get
    Given an Author is present in API
    When getAuthor request is received for the Author
    Then the response status code is 200
    And the response matches 'SINGLE_AUTHOR' schema
    And API returns Author details
