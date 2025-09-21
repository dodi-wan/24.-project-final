

@web
Feature: Test button home on homepage


  Background:
    Given user is on homepage saucedemo
    When user input username "standard_user" and password "secret_sauce"
    And user click button login
    Then verify user already login page saucedemo


    @web
Scenario: Test menu feature homepage login
      When user click 3 strips menu at top-left window
      And click button About
      Then verify new homepage about