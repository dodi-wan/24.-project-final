

@web
Feature: Button All item on homepage menu bar saucedemo


  Background:
    Given verify on homepage
    And input "standard_user" and "secret_sauce"
    Then click button login


Scenario: Test button About Us on homepage menu bar
  Given verify login
  When click shop cart
  And click 3 strips menu at top-left window
  Then click all item button
