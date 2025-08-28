
@web
Feature: Navigation filter product, price and alphabet


  Background:
    Given verify on homepage
    And input "standard_user" and "secret_sauce"
    Then click button login


  Scenario: Test button filter by name
    Given verify login
    And click icon logo filter "Name (A to Z)"
    Then choose Name (A to Z)
    Given verify product Name (A to Z)
    And choose Name (Z to A)
    Given verify product Name (Z to A)


  Scenario: Test button filter by price
    Given verify login
    And click icon logo filter "Name (A to Z)"
    Then choose Price (low to high)
    Given verify product Price (low to high)
    And choose Price (high to low)
    Given verify product Price (high to low)