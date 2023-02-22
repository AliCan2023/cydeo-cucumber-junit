package com.cydeo.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepDefinitions {


    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("user enters librarian username");
    }

    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("user enters librarian password");
    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {// this reusable and don't need to write again for the second scenario;
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
        System.out.println("user should see the dashboard");
    }

    @When("user enters student username")
    public void user_enters_student_username() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
        System.out.println("user enters student username");

    }
    @When("user enters student password")
    public void user_enters_student_password() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("user enters student password");
    }

    @When("user enters admin username")
    public void userEntersAdminUsername() {
        System.out.println("user enters admin username");
    }

    @And("user enters admin password")
    public void userEntersAdminPassword() {
        System.out.println("user enters admin password");

    }
}
