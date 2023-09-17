Feature: Midtrans Feature

  Scenario: Enter credentials
    Given user initializing the chrome browser SC
    When  user navigate to "https://demo.midtrans.com" SC
    Then  user verify the logo SC
    Then  user clicks on BUY NOW Button SC
    Then  user verify shopping cart popup SC
    Then  user clear the name text field and enter the name as "Piyush Verma" SC
    Then  user clear the email text field and enter the email as "piyush@demo.com" SC
    Then  user clear the phoneNo text field and enter the phoneNo as "1234567890" SC
    Then  user clear the city city text field and enter the city as "Meerut" SC
    Then  user clear the address text field and enter the address as "Shastri Nagar, Meerut" SC
    Then  user clear the pincode text fields and enter the pincode as "3482422" SC
    Then  user closes the chrome browser SC