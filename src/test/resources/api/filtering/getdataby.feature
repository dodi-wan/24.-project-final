
@Api
Feature: Get user data by single id and bulk id

  description:
  the id someday will be null because the data does changing on dummyapi.io

  Scenario: Test get user by single id
    When user get data id "60d0fe4f5311236168a109f3"
    Then response is 200



    Scenario Outline: Test get user by bulk id
      When user get bulk "<id>"
      Then status ok response is 200
      Examples:
      |           id             |
      | 60d0fe4f5311236168a109e6 |
      | 60d0fe4f5311236168a109e7 |
      | 60d0fe4f5311236168a109e9 |
      | 60d0fe4f5311236168a109ea |
      | 60d0fe4f5311236168a109eb |


