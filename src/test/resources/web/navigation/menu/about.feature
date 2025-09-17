

@web
Feature: Test button home on homepage


  Background:
    Given verify on homepage
    And input "standard_user" and "secret_sauce"
    Then click button login
    Given verify login


    @web
Scenario: Test menu feature homepage login
  And click 3 strips menu at top-left window
  And click button About
  Then verify new homepage about