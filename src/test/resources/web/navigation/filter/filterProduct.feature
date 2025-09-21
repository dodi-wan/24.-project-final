
@web
Feature: Navigation filter product, price and alphabet


  Background:
    Given user is on homepage saucedemo
    When user input username "standard_user" and password "secret_sauce"
    And user click button login
    When click icon logo filter "Name (A to Z)"


@web
  Scenario: Test button filter by name
    And choose Name (A to Z)
    Then verify product Name (A to Z)
    When choose Name (Z to A)
    Then verify product Name (Z to A)


  @web
  Scenario: Test button filter by price
    And choose Price (low to high)
    Then verify product Price (low to high)
    When choose Price (high to low)
    Then verify product Price (high to low)