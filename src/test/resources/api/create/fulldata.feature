
@Api
Feature: Create full data


  Scenario Outline: Test create full of data
    Given input "<title>" "<firstname>" "<lastname>" "<email>" "<dateOfBirth>" "<phone>" "<picture>" and location "<street>" "<city>" "<state>" "<country>" "<timezone>"
    Then status code should 200
    And delete user


    Examples:
      | title | firstname | lastname  | email          | dateOfBirth| phone      | picture         | street    | city | state        | country | timezone  |
      |  dr   | joko      | widodo    | rajajawa@psi.com | 1968/6/12  | 0866667777 | www.rajamulyono | surakarta | solo | central java | konoha  | +07.00    |

#  68a563c80494df0ae2cb802d
#  68a5716619a18b736af983f3u