Feature:  examples of Cucumber data table implementations


  Scenario: List of fruit I like

    Then user should see fruit I like

      | Banana   |
      | Cucumber |
      | Kiwi     |
      | Orange   |
      | Mango    |
      | Grape    |

  @wip
  Scenario: Shopping List of fruit I am buying

    Then user should see fruit I am buying

      | Banana   | 2 |
      | Cucumber | 3 |
      | Kiwi     | 4 |
      | Orange   | 6 |
      | Mango    | 2 |
      | Grape    | 3 |

