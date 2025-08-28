

@web
Feature: Log out uses credential username and password

  Background:
    Given verify on homepage
    And input "problem_user" and "secret_sauce"
    Then click button login

  Scenario: Test logout credential data
    Given verify login
    And click 3 strips menu at top-left window
    Then click logout
    Given verify on homepage