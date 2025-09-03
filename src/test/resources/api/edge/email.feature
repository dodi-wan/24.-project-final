

@Api
Feature: Boundary value name field and birth

  description:
  minimum format email "a@b.co"
  email only input @

  Scenario Outline: Test create field name more 50 characters
    Given user input data "<title>" "<firstname>" "<lastname>" "<email>"
    Then code should be 400

    Examples:
      | title | firstname| lastname  | email |
      |  mr   | Ronaldo  | Waluyo    |   @   |

