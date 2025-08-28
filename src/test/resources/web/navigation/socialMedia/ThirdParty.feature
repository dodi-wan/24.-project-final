

@web
Feature: Third party social media



  Background:
    Given verify on homepage
    And input "standard_user" and "secret_sauce"
    Then click button login

Scenario: Test link navigate social media
  When click icon twitter
  When click icon facebook
  When click icon linkedin