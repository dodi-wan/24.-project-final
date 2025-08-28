

@web
Feature: Add to cart product


  Background:
    Given verify on homepage
    And input "standard_user" and "secret_sauce"
    Then click button login


  Scenario: Test feature add to cart product
    Given verify login
    And click add to cart product
    And click shop cart


    Scenario: Test add product then remove it
      Given verify login
      And click add to cart product
      And click shop cart
      Then remove product






