
@Api
  Feature: filter data have been created in current environment

    description:
    In case you want to get only items created in current environment

    Scenario: Test data have been created in current environment
      When user want see data have been created in current environment
      Then status response is 200