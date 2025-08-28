

@web
Feature: Failure checkout empty product with input symbol data customer

  Background:
    Given verify on homepage
    And input "standard_user" and "secret_sauce"
    Then click button login

  Scenario Outline: Test checkout empty product with symbol data customer
    Given verify login
    And click shop cart
    And click checkout
    And input "<firstname>" "<lastname>" "<zip code>"
    Then click continue
    Then click finish button
    Given can see title "Thank you for your order!"

    Examples:
      |   firstname  |  lastname  |  zip code  |
      |       %      |      #     |     @      |