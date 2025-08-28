

@web
Feature: bulk Add to cart product


  Background:
    Given verify on homepage
    And input "standard_user" and "secret_sauce"
    Then click button login

  Scenario: Test feature add to cart all product
    Given verify login
    And click all add to cart product
    Then verify how many product at shop cart


  Scenario: Test feature add to cart all product
    Given verify login
    And click all add to cart product
    Then remove all product
