

@api
Feature: edit all data existing

  Scenario Outline: Test edit and update all data dummy api
    Given update data "<title>"

    Examples:
      | title |
      | king  |