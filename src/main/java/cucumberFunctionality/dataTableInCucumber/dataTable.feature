Feature: Data Table In Cucumber

  Scenario: Enter credentials using Data Table
    Given user opens the chrome browser DT
    When  user navigate to URL DT
    Then  user verify logo DT
    Then  user clicks on BUY NOW Button DT
    Then  user verify shopping cart popup DT
    Then  user enter credentials DT
      |Piyush Verma|piyush@demo.com|1234567890|Meerut|Shivaji Park, Meerut|200010|
    Then  user closes the browser DT

