
@api
Feature: Test data API

  Scenario: Test API GET data all users
    When user GET all data on API dummyapi.io
    Then the response status code is 200
