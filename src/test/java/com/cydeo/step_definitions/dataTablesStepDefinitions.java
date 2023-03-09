package com.cydeo.step_definitions;

import com.cydeo.pages.DropdownsPage;
import com.cydeo.utilities.BrowserUtilities;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class dataTablesStepDefinitions {

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }

    @Then("user should see fruit I like")
    public void user_should_see_fruit_i_like(List<String> fruits) {

        System.out.println(fruits);
        System.out.println(fruits.get(2));

    }


    @Then("user should see fruit I am buying")
    public void userShouldSeeFruitIAmBuying(Map<String,Integer> fruitsBuy) {
        System.out.println(fruitsBuy);
    }



    DropdownsPage dropdownsPage = new DropdownsPage();
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonths) {

//        Select select = new Select(dropdownsPage.monthDropdowns);
//        //List of all actual months Options as webElements;
//       List<WebElement> actualOptionsAsWebElement=  select.getOptions();
//
//       //create a list of String and pass all actual webElement options' string into new list;
//       List<String> actualOptionsAsString = new ArrayList<>();
//
//        for (WebElement each : actualOptionsAsWebElement) {
//
//            actualOptionsAsString.add(each.getText());
//        }
        //System.out.println(actualOptionsAsString);
        List<String> actualMonths = BrowserUtilities.dropdownOptionsAsString(dropdownsPage.monthDropdowns);
        Assert.assertEquals(expectedMonths,actualMonths);
        //Assert will check he size of the list first if it matches it checks the content onw by one;
        //System.out.println("expectedMonths = " + expectedMonths);


    }
}
