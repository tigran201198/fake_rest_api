Feature: Delete Book - happy paths

  Scenario: an existing Book can be deleted
    Given a Book is present in API
    When deleteBook request is received for the Book
    Then the response status code is 200
    And API returns empty response
