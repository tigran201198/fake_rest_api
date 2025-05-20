Feature: Get Books - happy paths

  Scenario: all Books can be get
    Given Books are present in API
    When getAllBooks request is received
    Then the response status code is 200
    And the response matches 'MULTIPLE_BOOKS' schema
    And API returns Books details
