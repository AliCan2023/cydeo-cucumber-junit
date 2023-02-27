package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleStepDefinition {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @When("user types {word} and clicks enter") // int this case I should comment out the one that we search for apple below;
    public void userTypesAndClicksEnter2(String  searchKeyword) {
        googleSearchPage.searchBox.sendKeys(searchKeyword + Keys.ENTER);
    }

    @When("user types {string} and clicks enter")
    public void userTypesAndClicksEnter(String searchKeyword) {
        googleSearchPage.searchBox.sendKeys(searchKeyword + Keys.ENTER);
    }

    @Then("user sees {string} in the title")
    public void userSeesInTheTitle(String string) {

        String expectedTitle =string + " - Google'da Ara";
        String actualTitle = Driver.getDriver().getTitle();
        //Junit assertion accepts first argument as expected,second arg as actual;
        Assert.assertEquals("Title is not expected!",expectedTitle,actualTitle);
    }

//    @When("user types apple and clicks enter") // if you keep this one and run the CucuRunner throws AmbiguousStepDefinitionsException;
//    public void userTypesAppleAndClicksEnter() {
//        googleSearchPage.searchBox.sendKeys("apple" + Keys.ENTER);
//        //System.out.println("user types apple and clicks enter");
//    }
    @Then("user sees {word} in the title")
    public void userSeesAppleInTheTitle(String word ) {
        String expectedTitle = word + " - Google'da Ara";
        String actualTitle = Driver.getDriver().getTitle();
        //Junit assertion accepts first argument as expected,second arg as actual;
        Assert.assertEquals("Title is not expected!",expectedTitle,actualTitle);

        //Assert.assertTrue(actualTitle.equals(expectedTitle));

        //System.out.println("user sees apple in the title");
    }

    @When("user is on Google search page")
    public void user_is_on_google_search_page() {
        //System.out.println("user is on Google search page");

        Driver.getDriver().get("https://www.google.com");
    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        //System.out.println("user should see title is Google");
        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
        Driver.closeDriver();

    }



}
