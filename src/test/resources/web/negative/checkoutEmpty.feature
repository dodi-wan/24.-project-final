

@web
Feature: Failure checkout empty product with input symbol data customer

  Background:
    Given verify on homepage
    And input "standard_user" and "secret_sauce"
    Then click button login
    Given verify login


    @web
  Scenario Outline: Test checkout empty product with symbol data customer
    And click shop cart
    And click checkout
    And input "%" "#" "@"
    Then click continue
    Then click finish button
    Then the result is showed text "<message>"

      Examples:
        |                                         message                                        |
        |                               Thank you for your order!                                |
        |Your order has been dispatched, and will arrive just as fast as the pony can get there! |
        |                                 Checkout: Complete!                                    |