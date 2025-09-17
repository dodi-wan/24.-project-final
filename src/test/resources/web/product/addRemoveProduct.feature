

@web
Feature: Add to cart product


  Background:
    Given verify on homepage
    And input "standard_user" and "secret_sauce"
    Then click button login
    Given verify login


@web
  Scenario: Test feature add to cart product
    And click add to cart product
    And click shop cart
    Then see product at shopping cart


@web
    Scenario: Test add product then remove it
    And click add to cart product
    Then remove product
    Given text add to cart






