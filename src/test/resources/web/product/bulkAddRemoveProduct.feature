

@web
Feature: bulk Add to cart product


  Background:
    Given user is on homepage saucedemo
    When user input username "standard_user" and password "secret_sauce"
    And user click button login
    Then verify user already login page saucedemo


  @web
  Scenario: Test feature add to cart all product
    And click all add to cart product
    Then verify how many product at shop cart


  @web
  Scenario: Test feature add to cart all product
    And click all add to cart product
    Then remove all product
    Then verify has been click remove
