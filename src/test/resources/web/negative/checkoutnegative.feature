

@web
Feature: Negative checkout no input product input firstname, lastname, zip with symbol character

  Background:
    Given user is on homepage saucedemo
    When user input username "standard_user" and password "secret_sauce"
    And user click button login
    Then verify user already login page saucedemo


    @web
  Scenario Outline: Test checkout no input product with symbol data customer
      When user click add to cart product
      And user click shop cart
      And user click checkout
      But user input valid credentials "%" "#" "@"
      And user click continue button
      When user click finish button
      Then user can see title "<message order>"

      Examples:
        |                                    message order                                       |
        |                               Thank you for your order!                                |
        |Your order has been dispatched, and will arrive just as fast as the pony can get there! |
        |                                 Checkout: Complete!                                    |