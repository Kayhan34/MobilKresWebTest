@smoke
Feature: Login MKWeb

  Background:
    Given user go to the login page

  Scenario: positive login test
    When user enters correct credentials
    Then user should be in "Anasayfa"
    Then user should be out

  Scenario: negative login test
    When user enters wrong credentials
    Then user should see "Alert"