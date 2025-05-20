Feature: Update Book - sad paths

  Scenario Outline: a Book with required fields missing cannot be updated
    Given a Book is present in API
    And the Book without <field> field was updated but not added to API yet
    When updateBook request is received for the Book
    Then the response status code is 400
    And the response matches 'ERROR' schema
    And API returns VALIDATION error
    Examples:
      | field       |
      | pageCount   |
      | publishDate |

  Scenario: a not existing Book cannot be updated
    Given a Book was not added to API yet
    When updateBook request is received for the Book
    Then the response status code is 404
    And the response matches 'ERROR' schema
    And API returns NOT_FOUND error
