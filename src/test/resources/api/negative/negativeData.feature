
  Feature: negative title

    Scenario Outline:
      Given input "<title>" "<firstname>" "<lastname>" "<email>" "<gender>"
      Then status code 400


      Examples:
        | title   | firstname | lastname |           email         | gender |
        |  king   | monkey d  | luffy    | kingpirate@onepiece.com | hybird |