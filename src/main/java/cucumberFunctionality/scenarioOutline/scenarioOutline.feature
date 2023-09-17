Feature: Scenario Outline feature

  Scenario Outline: : Scenario for testing different values
    Given user initializing the chrome browser SO
    When  user navigate to "<URL>" SO
    Then  user verify logo SO
    Then  user clicks on BUY NOW Button SO
    Then  user verify shopping cart popup SO
    Then  user clear name textField and enter name "<Name>" SO
    Then  user clear email textField and enter email "<Email>" SO
    Then  user clear phoneNo textField and enter phoneNo "<ContactNo>" SO
    Then  user clear city textField and enter city "<city>" SO
    Then  user clear address textField and enter address "<Address>" SO
    Then  user clear pincode textField and enter pincode "<Pincode>" SO
    Then  user closes the browser SO


    Examples:
      | URL                      | Name          | Email         | ContactNo     | city   | Address             | Pincode |
      |https://demo.midtrans.com/|Piyush Verma   |piyush@demo.com|123456         |Meerut  |Shastri Nagar, Meerut|250406   |
      |https://demo.midtrans.com/|Neeraj Aggarwal|neeraj@demo.com|234567         |Noida   |Sector 105, Noida    |203004   |
      |https://demo.midtrans.com/|Sarika Verma   |sarika@demo.com|345678         |Gurugram|Sector 40, Gurugram  |486292   |