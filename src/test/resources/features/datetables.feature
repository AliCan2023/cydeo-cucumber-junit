Feature:  examples of Cucumber data table implementations


  Scenario: List of fruit I like

    Then user should see fruit I like

      | Banana   |
      | Cucumber |
      | Kiwi     |
      | Orange   |
      | Mango    |
      | Grape    |


  Scenario: Shopping List of fruit I am buying

    Then user should see fruit I am buying

      | Banana   | 2 |
      | Cucumber | 3 |
      | Kiwi     | 4 |
      | Orange   | 6 |
      | Mango    | 2 |
      | Grape    | 3 |


    #day17-task6-Data tables task

  Scenario: User should be able to see all 12 months in months
  dropdown
    Given User is on the dropdowns page of practice tool
    Then User should see below info in month dropdown
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |




