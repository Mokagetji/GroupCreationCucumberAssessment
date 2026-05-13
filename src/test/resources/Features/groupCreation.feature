Feature: groupCreation

  Scenario Outline: as a user I want to login to ndosi website as admin and create a group
    Given i am ndosi automation homepage
    And i click login button
    When i am on the login page
    And i enter admin email <email>
    And i enter admin password <password>
    When i click login submit button
    Then i should be logged in successfully as admin
    When i click on the profile button
    And i click admin panel
    Then i should be redirected to admin dashboard

    Examples:
      |email  | password |
      |admin@gmail.com  | @12345678 |

