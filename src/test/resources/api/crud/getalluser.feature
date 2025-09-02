
@api
Feature: Test data API

  Scenario: Test API GET data
    Given setup link dummyapi
    Then the response status code is 200
