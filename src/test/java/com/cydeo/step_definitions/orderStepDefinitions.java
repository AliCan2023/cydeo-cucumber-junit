package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.OrderPage;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtilities;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.List;

public class orderStepDefinitions {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    BasePage basePage = new BasePage();

    OrderPage orderPage = new OrderPage();

    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        //Getting the page using the URL from configuration.properties
        Driver.getDriver().get(ConfigurationReader.getProperty("web.table.url"));

        //calling our login method to log in to web table app
        webTableLoginPage.login();
        // clicking to "order" link to go to order page
        basePage.Order.click();

    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {

        Select select = new Select(orderPage.productDropdown);
        select.selectByVisibleText(string);
    }

    @When("user enters quantity {int}")
    public void user_enters_quantity(Integer int1) {
        // we are accepting string argument here in sendKey()method and here we trick the method turning the argument
        // into string by concatenation "" or send String.valueOf(int)
       // orderPage.inputQuantity.sendKeys(int1 + "");
        //clear method deletes everything in the box that we locate;
        //orderPage.inputQuantity.clear();// or else the quantity we send added to the one in the quantity box; so we clear the box;
        orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE); // the assured one;
        orderPage.inputQuantity.sendKeys(String.valueOf(int1));
    }

    @When("user enters customer name {string}")
    public void user_enters_customer_name(String string) {
        orderPage.inputName.sendKeys(string);

    }

    @When("user enters street {string}")
    public void user_enters_street(String string) {
        orderPage.inputStreet.sendKeys(string);

    }

    @When("user enters city {string}")
    public void user_enters_city(String string) {
        orderPage.inputCity.sendKeys(string);

    }

    @When("user enters state {string}")
    public void user_enters_state(String string) {
        orderPage.inputState.sendKeys(string);

    }

    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        orderPage.inputZip.sendKeys(string);

    }

    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String expectedCardType) {

        //This line will loop through the list and decide which radio button to click;
        BrowserUtilities.clickRadioButton(orderPage.cardType,expectedCardType);
    }
    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
        orderPage.cardNoInput.sendKeys(string);
    }
    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
        orderPage.cardExpInput.sendKeys(string);
    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {
        orderPage.processOrderButton.click();
    }


}


