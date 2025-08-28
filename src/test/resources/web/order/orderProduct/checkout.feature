
@web
Feature: order product


  Background:
    Given verify on homepage
    And input "standard_user" and "secret_sauce"
    Then click button login

  Scenario Outline: Test order product
    When user click add to cart product "Sauce Labs Bike Light" and "Test.allTheThings() T-Shirt (Red)"
    And click shop cart
    And click checkout
    And input "<firstname>" "<lastname>" "<zip code>"
    Then click continue
    Then click finish button
    Given can see title "Thank you for your order!"

    Examples:
      |   firstname  |  lastname  |  zip code  |
      |   Monkey     |  D Gibran  |     1987   |
