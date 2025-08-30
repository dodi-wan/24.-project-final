
@Api
Feature: Create a data user API


  Scenario: Test create a data user API
    Given link url dummyapi
    When create data the firstname Randy and the lastname Orton
    Then status code 200
    And update data
    Then response update data should 200
    And delete data
    Then response delete data should 200
