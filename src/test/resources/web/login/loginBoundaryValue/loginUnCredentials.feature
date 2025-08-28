
@web
Feature: Login automation non-credential


  Description:
  boundary value input username minimum 8 character. Expected: message error, input username less 8 character
  boundary value input username max 21 character. Expected: if input username less 21 character
  message show "performance_glitch_user"


  Scenario Outline: Test login non-credential list website
    Given verify on homepage
    And input "<username>" and "<password>"
    Then click button login
    Given verify login

    Examples:
      |     username                  |   password          |
      |     standard_use              |   secret_sauce      |
      |     standard_user             |   secret_saucer     |
      |     konoha                    |   secret_sauce      |
      |                               |   secret_sauce      |
      |     standard_user             |                     |
      |                               |                     |