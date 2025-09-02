
@Api
Feature: Get data single and bulk



  Scenario: Test get data single
    And get data id "60d0fe4f5311236168a109d4"
    Then response is 200



    Scenario Outline: Test get bulk data
      When get bulk "<id>"
      Then status ok response is 200
      Examples:
      |           id             |
      | 60d0fe4f5311236168a109e6 |
      | 60d0fe4f5311236168a109e7 |
      | 60d0fe4f5311236168a109e9 |
      | 60d0fe4f5311236168a109ea |
      | 60d0fe4f5311236168a109eb |


