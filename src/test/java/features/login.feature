Feature: login user


  Scenario: Login with bad user
    Given enter the login form
    When type user and password
      | user                 | pass |
      | Adminstrador         | admin123   |
    Then show message user or password wrong
