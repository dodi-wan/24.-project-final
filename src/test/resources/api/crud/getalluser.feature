
@api
Feature: Test data API

  Scenario: Test API GET data all users
    Given show all the users dummyapi
    Then the response status code is 200
