

@web
Feature: Third party social media Linkedin

  Background:
    Given verify on homepage
    And input "standard_user" and "secret_sauce"
    Then click button login
    Given verify login

  @web
Scenario: Test link navigate social media Linkedin
  When click icon linkedin
  Then verify homepage linkedin