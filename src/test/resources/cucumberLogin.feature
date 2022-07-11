@Smoke
Feature: Login function test

  @tc002_to_tc003 @prositive
  Scenario: As an orbis user,do successfull login with valid credenttial
    Given Open Browser
    And go to Application URL
    When put valid user name
    And put valid password
    And click signin button
    Then login should be successfull and showed sign out button
    And close browser
