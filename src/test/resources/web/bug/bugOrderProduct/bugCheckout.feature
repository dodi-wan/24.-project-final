

@web
Feature: order bug product


  Background:
    Given verify on homepage
    And input "standard_user" and "secret_sauce"
    Then click button login

  Scenario Outline: Test bug order product
    And click add to cart product
    And click shop cart
    Then remove product
    And click checkout
    And input "<firstname>" "<lastname>" "<zip code>"
    Then click continue
    Then click finish button
    Given can see title "Thank you for your order!"

    Examples:
      |   firstname  |  lastname  |  zip code  |
      |   Monkey     |  D Gibran  |     1987   |