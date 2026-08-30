Feature: Login Functionality of Stock Accounting Application
  As a user of Stock Accounting
  I want to login to the application
  So that I can manage stock, suppliers and customers

  Background:
    Given User is on the Login Page

  @Smoke @Positive
  Scenario: Successful Login with valid credentials
    When User enters username "admin" and password "master"
    And User clicks on Login button
    Then User should be navigated to the Dashboard
    And Logout link should be visible

  @Negative
  Scenario Outline: Login with invalid credentials
    When User enters username "<username>" and password "<password>"
    And User clicks on Login button
    Then Error message should be displayed or user stays on Login page

    Examples:
      | username    | password  |
      | invaliduser | master    |
      | admin       | wrongpass |
      |             | master    |
      | admin       |           |
