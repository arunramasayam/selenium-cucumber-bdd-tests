Feature: User Sign Up
  As a new user
  I want create an account
  to access the application

  Background: 
    Given I navigate to the "https://xaltsocnportal.web.app/"
    When I click on the 'Get Started' button
    Then I should be on the Sign In page

  Scenario: Successful Sign Up and Sign Out
    And I enter a valid email for sign up and a strong password
    And I confirm the password correctly
    And I click on the Sign Up button
    Then I should see the 'Sign Out' button
    When I click on the 'Sign Out' button
    And I should see the 'Sign In' button

  Scenario Outline: Sign Up with an Already Registered Email
    And I enter an already registered <Email> for sign up and a strong <Password>
    And I confirm the password correctly
    And I click on the Sign Up button
    Then I should see an <ErrorMessage> error message

    Examples: 
      | Email             | Password   | ErrorMessage                      |
      | test@testmail.com | Xalts@2025 | Provided E-Mail is already in use |

  Scenario Outline: Sign Up button disabled if email or password is invalid
    And I enter an invalid <Email> or a weak <Password>
    And I confirm the password correctly
    Then the Sign Up button should remain disabled

    Examples: 
      | Email            | Password    |
      | invalid-email    | Xalts@2025  |
      | test@mail.com    |       12345 |
      | test@mail.com    | password123 |
      | invalidemail.com | weakpass    |
      |                  | Test@123456 |
      | test@mail.com    | Weakpass    |
      |                  |             |

  Scenario Outline: Sign Up button disabled when password confirmation does not match
    And I enter valid <Email> and <Password>
    And I enter a different <ConfirmPassword>
    Then the Sign Up button should remain disabled

    Examples: 
      | Email            | Password   | ConfirmPassword |
      | test@mail.com    | Xalts@2025 | Xalts@2024      |
      | user@test.com    | Secure@123 | Secure123       |
      | another@test.com | Pass@5678  | Pass5678        |
