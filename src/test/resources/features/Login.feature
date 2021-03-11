Feature: Feature to login gmail application

Scenario Outline: Login with valid credentials
  Given user is on gmail login page
  When user enters <"username"> and <"password">
  And user clicks on login button
  Then user should be navigated to gmail inbox

  Examples:
  | username      | password |
  | abc@gmail.com |          |
  | xyz@gmail.com |          |

  Scenario Outline: Login with invalid credentials
    Given user is on gmail login page
    When user enters <"username"> and <"password">
    And user clicks on login button
    Then user should be presented with an <"errorMessage">

    Examples:
      | username      | password | errorMessage |
      | abc@gmail.com |          |              |
      | xyz@gmail.com |          |              |