package com.cydeo.step_definitions;

import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class dataTablesStepDefinitions {

    @Then("user should see fruit I like")
    public void user_should_see_fruit_i_like(List<String> fruits) {

        System.out.println(fruits);
        System.out.println(fruits.get(2));

    }


    @Then("user should see fruit I am buying")
    public void userShouldSeeFruitIAmBuying(Map<String,Integer> fruitsBuy) {
        System.out.println(fruitsBuy);
    }
}
