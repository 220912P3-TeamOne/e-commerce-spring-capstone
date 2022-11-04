package com.revature.steps;

import com.revature.runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserProfileSteps {

    public static WebDriver driver = Runner.driver;

    @Given("the user is signed in")
    public void the_user_is_signed_in() {
        driver.get("http://localhost:3000/");
        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.titleContains("Congo"));
        WebElement signinLink = driver.findElement(By.xpath("//*[@class='sc-jSMfEi ikjYxj'][2]"));
        signinLink.click();
    }

    @When("the user is on the profile page")
    public void the_user_is_on_the_profile_page() {
        new WebDriverWait(driver, 7)
            .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@class='sc-jSMfEi ikjYxj']"))));
        WebElement profileLink = driver.findElement(By.xpath("//*[@class='sc-jSMfEi ikjYxj']"));
        profileLink.click();
    }

    @Then("the user should be on the User Dashboard page")
    public void the_user_should_be_on_the_user_dashboard_page() {
        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.tagName("h2")), "Dashboard"));//having trouble locating this element
        Assertions.assertEquals("Welcome to your Dashboard, User!", driver.findElement(By.tagName("h2")).getText());
    }

    @Given("the user is on the User Dashboard page")
    public void the_user_is_on_the_user_dashboard_page() {
        //get url
        //click signin
        //signin
        //find profile link
        //click profile link
    }

    @When("the user types in {string} into the First Name Field")
    public void the_user_types_in_into_the_first_name_field(String string) {
        //find first name field
        //sendkeys
    }

    @When("the user types in {string} into the Last Name Field")
    public void the_user_types_in_into_the_last_name_field(String string) {
        //find last name field
        //sendkeys
    }

    @When("the user types in {string} into the Password Field")
    public void the_user_types_in_into_the_password_field(String string) {
        //findpassword
        //sendkeys
    }

    @When("the user clicks on the update button")
    public void theUserClicksOnTheUpdateButton() {
        //findupdateButton
        //clickupdatebutton
    }

    @Then("the user should receive an alert that reads {string}")
    public void the_user_should_receive_an_alert_that_reads(String string) {
        //wait for alert
        //dismiss alert
    }


}