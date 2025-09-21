

@web
Feature: Log out uses credential username and password

  Background:
    Given user is on homepage saucedemo
    When user input username "visual_user" and password "secret_sauce"
    And user click button login
    Then verify user already login page saucedemo

  @web
  Scenario: Test logout credential data glitch user
    When user click 3 strips menu at top-left window
    And user click logout
    Then user already on homepage login
