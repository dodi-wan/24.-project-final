
@Api
Feature: Create a data user API


  Scenario Outline: Test create a data user API
    Given input data "<title>" "<firstname>" "<lastname>" "<email>"
    Then status code is 200
    And delete data
    Then response delete data should 200

    Examples:
      | title | firstname | lastname  | email            |
      |  mr   | Randy      | Orton    | viperko@wwe.com |
