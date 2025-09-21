
@web
Feature: message login


  Description:
  boundary value input username minimum 8 character. Expected: message error, input username less 8 character
  boundary value input username max 21 character. Expected: if input username less 21 character
  message show "performance_glitch_user"



@web
   Scenario Template: Test verify message login
      Given user is on homepage saucedemo
      When user input username "<username>" and password "<password>"
      And user click button login
      Then user can see "<Expected message>"

  Examples:
        |     username             |   password        |                        Expected message                                   |
        |     standard_use         |   secret_sauce    | Epic sadface: Username and password do not match any user in this service |
        |     standard_user        |   secret_saucer   | Epic sadface: Username and password do not match any user in this service |
        |     locked_out_user      |   secret_sauce    | Epic sadface: Sorry, this user has been locked out.                       |
        |     konoha               |   secret_sauc     | Epic sadface: Username and password do not match any user in this service |
        |                          |   secret_sauce    | Epic sadface: Username is required                                        |
        |     standard_user        |                   | Epic sadface: Password is required                                        |
        |                          |                   | Epic sadface: Username is required                                        |
        | performance_glitch_userr | secret_sauce      | Epic sadface: Username and password do not match any user in this service |
