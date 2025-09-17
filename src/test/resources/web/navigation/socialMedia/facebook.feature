

@web
Feature: Third party Facebook

  Background:
    Given verify on homepage
    And input "standard_user" and "secret_sauce"
    Then click button login
    Given verify login

  @web
Scenario: Test link navigate social media facebook
  When click icon facebook
  Then verify homepage facebook