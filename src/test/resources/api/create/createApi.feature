
@Api
Feature: Create a data user API


  Scenario: Test create a data user API
    Given link url dummyapi
    When create data the firstname Randy and the lastname Orton
    Then update data
    And delete data
