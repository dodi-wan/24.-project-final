
@Api
Feature: Boundary Value birth date


  Background: birth 1/1/1900

  @Api
Scenario Outline: Test input below 1900
  Given input "<title>" "<firstname>" "<lastname>" "<email>" "<dateOfBirth>"
  Then status response is 400

  Examples:
    | title | firstname | lastname  | email               | dateOfBirth |
    |  mr   | neymar    | jr        | neymarjr@brasil.com | 1987/6/14  |