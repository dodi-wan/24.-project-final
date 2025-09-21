

@web
Feature: Button All item on homepage menu bar saucedemo


  Background:
    Given user is on homepage saucedemo
    When user input username "standard_user" and password "secret_sauce"
    And user click button login
    Then verify user already login page saucedemo


@web
Scenario: Test button About Us on homepage menu bar
  When user click add to cart product
  When user click 3 strips menu at top-left window
  And click all item button
  Then verify user already login page saucedemo
