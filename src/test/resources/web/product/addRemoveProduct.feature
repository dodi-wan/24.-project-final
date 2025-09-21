

@web
Feature: Add to cart product


  Background:
    Given user is on homepage saucedemo
    When user input username "standard_user" and password "secret_sauce"
    And user click button login
    Then verify user already login page saucedemo


@web
  Scenario: Test feature add to cart product
    When user click add to cart product
    And user click shop cart
    Then see product at shopping cart


@web
    Scenario: Test add product then remove it
    When user click add to cart product
    But user remove product
    Then verify has been click remove






