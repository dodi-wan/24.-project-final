

@web
Feature: Third party social media Linkedin

  Background:
    Given user is on homepage saucedemo
    When user input username "standard_user" and password "secret_sauce"
    And user click button login
    Then verify user already login page saucedemo

  @web
Scenario: Test link navigate social media Linkedin
  When click icon linkedin
  Then verify homepage linkedin