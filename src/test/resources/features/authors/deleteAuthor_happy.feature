Feature: Delete Author - happy paths

  Scenario: an existing Author can be deleted
    Given an Author is present in API
    When deleteAuthor request is received for the Author
    Then the response status code is 200
    And API returns empty response
