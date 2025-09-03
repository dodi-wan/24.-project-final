
@Api
 Feature: Boundary value name field and birth

   description:
   firstName: string(length: 2-50)
   dateOfBirth: string(ISO Date - value: 1/1/1900 - now)

  Scenario Outline: Test create field name more 50 characters
    Given input data "<title>" "<firstname>" "<lastname>" "<email>" "<dateOfBirth>"
    Then code is 400

    Examples:
    | title | firstname                                                      | lastname  | email                     | dateOfBirth  |
    |  mr   |abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz  | neymar    | neymarjrsantos@brasil.com | 1/0/1989     |
    |  ms   | a                                                              |    b      | ab@email.com              | 0/0/1889     |

