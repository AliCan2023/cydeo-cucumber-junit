Feature: Wikipedia search functionality and verifications
  #WSF-2365 //Potential Agile ticket number

  Scenario: Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia home page
    When  User types "Bill Gates" in the wiki search box
    And   User clicks wiki search button
    Then  User sees "Bill Gates" is in the wiki title

  Scenario: Wikipedia Search Functionality Header Verification
    Given User is on Wikipedia home page
    When  User types "Steve Jobs" in the wiki search box
    And   User clicks wiki search button
    Then  User sees "Steve Jobs" is in the main header

  @scenarioOutline
  Scenario Outline: Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia home page
    When  User types "<searchValue>" in the wiki search box
    And   User clicks wiki search button
    Then  User sees "<expectedTitle>" is in the wiki title
    Then  User sees "<expectedMainHeader>" is in the main header

    @soccerPlayers
    Examples: search values we are going to be using in this scenario is as below

      | searchValue    | expectedTitle  | expectedMainHeader |
      | Steve Jobs     | Steve Jobs     | Steve Jobs         |
      | C.Ronaldo      | C.Ronaldo      | C.Ronaldo          |
      | Angelina Julie | Angelina Julie | Angelina Julie     |
      | Ataturk        | Ataturk        | Ataturk            |
      | Marie Curie    | Marie Curie    | Marie Curie        |
      | Kemal Sunal    | Kemal Sunal    | Kemal Sunal        |
      | Turkan Soray   | Turkan Soraye  | Turkan Soray       |

    @scientist
    Examples:
      | searchValue     | expectedTitle   | expectedMainHeader |
      | Marie Curie     | Marie Curie     | Marie Curie        |
      | Oktay Sinanoglu | Oktay Sinanoglu | Oktay Sinanoglu    |
      | Aziz Sancar     | Aziz Sancar     | Aziz Sancar        |


