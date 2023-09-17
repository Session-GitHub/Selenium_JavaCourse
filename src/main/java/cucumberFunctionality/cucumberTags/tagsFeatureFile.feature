Feature: Cucumber Tags Feature

  @google
  Scenario: google tag Scenario1
    Given user open chrome browser1
    When  user enter "https://www.google.com" url1
    Then  user is on Google Home Page1
    Then  user close the browser1

  @facebook
  Scenario: facebook tag Scenario2
    Given user open chrome browser2
    When  user enter "https://www.facebook.com" url2
    Then  user is on Facebook Home Page2
    Then  user close the browser2

  @renewbuy
  Scenario: renewBuy tag Scenario3
    Given user open chrome browser3
    When  user enter "https://www.renewbuy.com" url3
    Then  user is on renewBuy Home Page3
    Then  user close the browser3

  @youtube
  Scenario: youtube tag Scenario4
    Given user open chrome browser4
    When  user enter "https://www.youtube.com" url4
    Then  user is on youtube Home Page4
    Then  user close the browser4