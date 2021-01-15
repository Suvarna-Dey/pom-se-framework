Feature: Automation login functionality in Dojo application

  Scenario Outline: Validation of email field at login page
    Given user is at DOJO application login page
    When user enters "<emailId>" in "email" field
    And user clicks on "password"
    Then user should be presented with "<errorMessage>" for "<errorField>"
    And login button should be disabled

  Examples:
    | emailId         | errorField | errorMessage           |
    | example.com     | email      | Invalid email address  |
    | example         | email      | Invalid email address  |
    |                 | email      | Email required         |

  Scenario Outline: Validation of password field at login page
    Given user is at DOJO application login page
    When user enters "<emailId>" in "email" field
    And user enters "<password>" in "password" field
    Then user should be presented with "<errorMessage>" for "password"
    And login button should be disabled

    Examples:
      | emailId          | password |errorMessage           |
      | test@example.com |          | Password required     |


    Scenario: Validation of forgot your password link
      Given user is at DOJO application login page
      When user clicks on "forgot your password"
      Then user should be able to enter email in reset password screen
      | email |
      | test@example.com      |
      When user clicks on email me reset button on reset password screen
      Then user should be presented with success message as below
      | message |
      | Please check your inbox for instructions on how to reset your password. It may take a few minutes to come through.|