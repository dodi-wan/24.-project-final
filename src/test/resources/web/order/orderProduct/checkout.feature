
@web
Feature: order product


  Background:
    Given verify on homepage
    And input "standard_user" and "secret_sauce"
    Then click button login
    Given verify login


@web
  Scenario Outline: Test order product
    When user click add to cart product "Sauce Labs Bike Light" and "Test.allTheThings() T-Shirt (Red)"
    And click shop cart
    And click checkout
    And input "Monkey" "D Gibran" "1987"
    Then click continue
    Then click finish button
    Then the result is showed text "<message>"

  Examples:
    |                                         message                                        |
    |                               Thank you for your order!                                |
    |Your order has been dispatched, and will arrive just as fast as the pony can get there! |
    |                                 Checkout: Complete!                                    |
