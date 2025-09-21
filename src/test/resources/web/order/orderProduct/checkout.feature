
@web
Feature: order product


  Background:
    Given user is on homepage saucedemo
    When user input username "standard_user" and password "secret_sauce"
    And user click button login
    Then verify user already login page saucedemo


@web
  Scenario Outline: Test order product
    When user click add to cart product "Sauce Labs Bike Light" and "Test.allTheThings() T-Shirt (Red)"
    And user click shop cart
    And user click checkout
    When user input valid credentials "Monkey" "D Gibran" "1987"
    And user click continue button
    When user click finish button
    Then user can see title "<message order>"

  Examples:
    |                                    message order                                       |
    |                               Thank you for your order!                                |
    |Your order has been dispatched, and will arrive just as fast as the pony can get there! |
    |                                 Checkout: Complete!                                    |
