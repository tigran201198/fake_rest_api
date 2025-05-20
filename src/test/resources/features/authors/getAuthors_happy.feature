Feature: Get Authors - happy paths

  Scenario: all Authors can be get
    Given Authors are present in API
    When getAllAuthors request is received
    Then the response status code is 200
    And the response matches 'MULTIPLE_AUTHORS' schema
    And API returns Authors details
