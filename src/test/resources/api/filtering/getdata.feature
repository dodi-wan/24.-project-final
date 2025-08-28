
@Api
Feature: Get data single and bulk



  Scenario: Test get data single
    Given access data api
    And status code should be 200
    Then get id data
#    Then choose id data api
#    And status code should be 200



    Scenario: Test get bulk data
