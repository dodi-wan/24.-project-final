
@Api
 Feature: Boundary value name field and birth

  Scenario Outline: Test create field name more 50 characters
    Given input data "<title>" "<firstname>" "<lastname>" "<email>" "<dateOfBirth>"
    Then code is 400

    Examples:
    | title | firstname                                                      | lastname  | email                     | dateOfBirth  |
    |  mr   |abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz  | neymar    | neymarjrsantos@brasil.com | 1/0/1989     |

