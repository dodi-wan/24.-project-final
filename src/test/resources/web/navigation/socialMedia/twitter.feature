

@web
Feature: Third party social media Twitter

  Background:
    Given verify on homepage
    And input "standard_user" and "secret_sauce"
    Then click button login
    Given verify login

  @web
  Scenario: Test link navigate social media Twitter
    When click icon twitter
    Then verify homepage twitter