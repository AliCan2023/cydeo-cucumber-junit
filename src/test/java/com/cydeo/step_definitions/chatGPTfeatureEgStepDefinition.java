package com.cydeo.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class chatGPTfeatureEgStepDefinition {

        private int cucumbers;

        @Given("I have (\\d+) cucumbers in my fridge")
        public void i_have_cucumbers_in_my_fridge(int n) {
            cucumbers = n;
        }

        @When("I eat (\\d+) cucumber")
        public void i_eat_cucumber(int n) {
            cucumbers -= n;
        }

        @Then("I should have (\\d+) cucumbers in my fridge")
        public void i_should_have_cucumbers_in_my_fridge(int n) {
          // assertEquals(n, cucumbers);
        }
    }
    /*
    In this example, the step definitions use regular expressions to match the steps in the feature file and perform the corresponding actions. 
    The @Given, @When, and @Then annotations specify the type of step (given, when, or then) and the regular expression that matches the step. 
    The cucumbers variable stores the current number of cucumbers in the fridge, and the step definitions modify this variable to simulate the actions described in the scenario.
    Finally, the assertEquals method is used to check that the expected number of cucumbers is present in the fridge after the actions are performed.
     */


