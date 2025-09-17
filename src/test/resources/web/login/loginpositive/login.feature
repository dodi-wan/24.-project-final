
@web
Feature: Login Automation


  Description;
  Login with credential list on saucedemo; Expected: username standard_user, problem_user, performance_glitch_user,
  error_user, visual_user can login and locked_out_user cannot login


  @web
  Scenario Outline: Test login credential list verifies website
    Given verify on homepage
    And input "<username>" and "<password>"
    Then click button login
    Given verify login

    Examples:
    |     username                  |   password          |
    |     standard_user             |   secret_sauce      |
    |     problem_user              |   secret_sauce      |
    |     performance_glitch_user   |   secret_sauce      |
    |     error_user                |   secret_sauce      |
    |     visual_user               |   secret_sauce      |

    @web
  Scenario: login username credential has been locked
    Given input "locked_out_user" and "secret_sauce"
    And click button login
    Then message "Epic sadface: Sorry, this user has been locked out."