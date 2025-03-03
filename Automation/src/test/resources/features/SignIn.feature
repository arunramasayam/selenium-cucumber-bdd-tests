Feature: User Sign In
  As a existing user
  I want to sign in
  to access my account

  Background: 
    Given I navigate to the "https://xaltsocnportal.web.app/"
    When I click on the 'Sign In' button
    Then I should be on the Sign In page
    And I click on 'Already have an account? click here to join' button
    Then I should see Sign In form

  Scenario Outline: Successful Sign In and Sign Out
    When I enter my registered <Email> for sign in and correct <Password>
    And I submit the Sign In form
    Then I should see the 'Sign Out' button
    When I click on the 'Sign Out' button
    And I should see the 'Sign In' button

    Examples: 
      | Email             | Password   |
      | test@testmail.com | Xalts@2025 |

  Scenario Outline: Sign In should be disabled for invalid inputs
    When I enter an invalid email <Email> or an invalid password <Password>
    Then the Sign In button should remain disabled

    Examples: 
      | Email             | Password   |
      | test@com          | Xalts123   |
      | user#domain.com   |     123456 |
      |                   | Xalts@2025 |
      | test@testmail.com |            |
      |                   |            |

  Scenario Outline: Sign In with Non-Existing User
    When I enter a non-existing <Email> and correct <Password>
    And I submit the Sign In form
    Then I should see a <Error> alert message

    Examples: 
      | Email             | Password   | Error          |
      | usertest@test.com | Xalts@2025 | User not found |

  Scenario Outline: Sign In with Existing User and Wrong Password
    When I enter an existing <Email> and wrong valid <Password>
    And I submit the Sign In form
    Then I should see an <Error> alert message

    Examples: 
      | Email             | Password      | Error                        |
      | test@testmail.com | WrongPass@123 | Incorrect E-Mail or Password |
