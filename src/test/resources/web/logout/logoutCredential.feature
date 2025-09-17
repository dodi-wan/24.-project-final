

@web
Feature: Log out uses credential username and password

  Background:
    Given verify on homepage
    And input "standard_user" and "secret_sauce"
    Then click button login
    Given verify login

    @web
    Scenario: Test logout credential data
      And click 3 strips menu at top-left window
      Then click logout
      Given verify on homepage