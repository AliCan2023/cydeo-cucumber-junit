Feature: User should be able to login using correct credentials

  Background: user is on the login page
    Given user is on the login page of web table app

  Scenario: Positive login scenario
    When user enters username "Test"
    And user enters password "Tester"
    And user clicks to login button
    Then user should see url contains orders

  Scenario: Positive login scenario
    When user enters username "Test" password "Tester" and logins
    Then user should see url contains orders

    #1-implement this new step
    #2-Create login method in WebTableLoginPage
    #this log in method should have multiple difference overload version

#day17-Task1-1#: Login scenario using maps/ alternative practice


  Scenario: User should be able to see all 12 months in months dropdown
    When User enters below credentials
      | username | Test   |
      | password | Tester |
    Then user should see url contains orders

    #Note that the column headers in the data table must match the variable names used in the step definition method.
    # If the variable names in the method are different from the column headers in the data table,
    # you can use the @DataTableType annotation to define a custom data table type that maps the column headers to the variable names.




