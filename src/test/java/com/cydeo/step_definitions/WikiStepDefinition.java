package com.cydeo.step_definitions;

import com.cydeo.pages.WikiSearch;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WikiStepDefinition {

    WikiSearch wikiSearch = new WikiSearch();


    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org");

    }

    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {

        wikiSearch.searchBox.sendKeys(string);

    }

    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikiSearch.searchButton.click();

    }

    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String string) {

        //verify actual title contains string;(coming from future file)
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));

    }

    @Then("User sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String string) {

        Assert.assertTrue(wikiSearch.mainHeader.isDisplayed());

        Assert.assertTrue(wikiSearch.mainHeader.getText().equals(string));
    }
}
