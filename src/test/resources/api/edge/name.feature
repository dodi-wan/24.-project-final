
@Api
 Feature: Boundary value name field


  Scenario Outline: Test create field name more 50 characters
    Given input "<title>" "<firstname>" "<lastname>" "<email>"
    Then code is 400

    Examples:
    | title | firstname                                                      | lastname  | email                     |
    |  mr   |abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz  | neymar    | neymarjrsantos@brasil.com |


#

