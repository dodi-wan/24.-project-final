

@web
Feature: Button All item on homepage menu bar saucedemo


  Background:
    Given verify on homepage
    And input "standard_user" and "secret_sauce"
    Then click button login
    Given verify login


@web
Scenario: Test button About Us on homepage menu bar
  When click shop cart
  And click 3 strips menu at top-left window
  Then click all item button
  Given verify all item button
