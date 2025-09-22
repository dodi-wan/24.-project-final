

@api
  Feature: negative create data variable gender

    Scenario Outline: Test create data with negative variable gender
      When user input "<title>" "<firstname>" "<lastname>" "<email>" "<gender>"
      Then status code 400


      Examples:
        | title   | firstname | lastname |           email         | gender |
        |  king   | monkey d  | luffy    | kingpirate@onepiece.com | hybird |