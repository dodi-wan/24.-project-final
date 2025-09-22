

@Api
Feature: create new id data and delete it then get id
  Scenario Outline: Test GET id have been delete it
    When user create data "<title>" "<firstname>" "<lastname>" "<email>"
    Then response status code is 200
    When user delete data id
    But user try get id already delete it
    Then response code is 404

    Examples:
      | title | firstname | lastname  | email               |
      |  mr   | Tiger     | East      | tigereast@east.com  |



  Scenario Outline: Test GET random id
    When user get "<id>"
    Then response status code 400

    Examples:
    |     id      |
    | 1945merdeka |
