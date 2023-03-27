Feature: Login MKWeb

  Background:
    Given user go to the login page

  @smoke
  Scenario: positive login test

    When user enters correct credentials
    Then user should be in "Anasayfa"

  @smoke
  Scenario: negative login test

    When user enters wrong credentials
    Then user should see "Alert"