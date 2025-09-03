

@Api
Feature: create data id delete then get id already delete it

  Scenario Outline: Test GET id have been delete it
    Given create data "<title>" "<firstname>" "<lastname>" "<email>"
    Then response status code is 200
    And delete data id
    Then get id user
    Then response code is 404

    Examples:
      | title | firstname | lastname  | email               |
      |  mr   | Tiger     | East      | tigereast@east.com  |



  Scenario Outline: Test GET random id
    Given get "<id>"
    Then response status code 400

    Examples:
    |     id      |
    | 1945merdeka |
