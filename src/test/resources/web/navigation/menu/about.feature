

@web
Feature: Test button home on homepage


  Background:
    Given verify on homepage
    And input "standard_user" and "secret_sauce"
    Then click button login

Scenario: Test menu feature homepage login
  Given verify login
  And click 3 strips menu at top-left window
  And click button About