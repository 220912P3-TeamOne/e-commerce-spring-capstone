package com.revature.steps;

import com.revature.runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UserProfileSteps {

    public static WebDriver driver = Runner.driver;

    @Given("the user is signed in")
    public void the_user_is_signed_in() {
        driver.get("http://localhost:3000/");
        WebElement logoutLink = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong"));
        logoutLink.click();
        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.titleContains("Congo"));
        WebElement signinLink = driver.findElement(By.xpath("//*[@class='sc-jSMfEi ikjYxj'][2]"));
        signinLink.click();
    }

    @When("the user is on the profile page")
    public void the_user_is_on_the_profile_page() {
        new WebDriverWait(driver, 7)
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/main/div/form/div[1]/div/input")));
        WebElement username = driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div/input"));
        username.sendKeys("thisisacongoemail@gmail.com");
        WebElement userpassword = driver.findElement(By.xpath("/html/body/div/main/div/form/div[2]/div/input"));
        userpassword.sendKeys("PassPass#1");
        WebElement signinButton = driver.findElement(By.xpath("/html/body/div/main/div/form/button"));
        signinButton.click();
        new WebDriverWait(driver, 7)
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong")));
        WebElement profileLink = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[1]/strong"));
        profileLink.click();
    }

    @Then("the user should be on the User Dashboard page")
    public void the_user_should_be_on_the_user_dashboard_page() {
        new WebDriverWait(driver, 7)
            .until(driver -> driver.findElement(By.xpath("//h2")));
        String message=driver.findElement(By.tagName("h2")).getText();
        Assertions.assertTrue(message.contains("Welcome to Your Dashboard"));
    }

    @Given("the user is on the User Dashboard page")
    public void the_user_is_on_the_user_dashboard_page() {
        driver.get("http://localhost:3000/");
        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.titleContains("Congo"));
        WebElement logoutLink = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong"));
        logoutLink.click();
        WebElement signinLink = driver.findElement(By.xpath("//*[@class='sc-jSMfEi ikjYxj'][2]"));
        signinLink.click();
        new WebDriverWait(driver, 7)
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/main/div/form/div[1]/div/input")));
        WebElement username = driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div/input"));
        username.sendKeys("thisisacongoemail@gmail.com");
        WebElement userpassword = driver.findElement(By.xpath("/html/body/div/main/div/form/div[2]/div/input"));
        userpassword.sendKeys("PassPass#1");
        WebElement signinButton = driver.findElement(By.xpath("/html/body/div/main/div/form/button"));
        signinButton.click();
        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong")));
        WebElement profileLink = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[1]/strong"));
        profileLink.click();
        new WebDriverWait(driver, 7)
                .until(driver -> driver.findElement(By.xpath("//h2")));
    }

    @When("the user types in {string} into the First Name Field")
    public void the_user_types_in_into_the_first_name_field(String string) {
        WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='firstName']"));
        firstNameInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), string);
    }

    @When("the user types in {string} into the Last Name Field")
    public void the_user_types_in_into_the_last_name_field(String string) {
        WebElement lastNameInput = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastNameInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), string);
    }

    @When("the user types in {string} into the Password Field")
    public void the_user_types_in_into_the_password_field(String string) {
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys(string);
    }

    @When("the user clicks on the update button")
    public void theUserClicksOnTheUpdateButton() {
        WebElement updateButton = driver.findElement(By.xpath("//button"));
        updateButton.click();
    }

    @Then("the user should receive an alert that reads {string}")
    public void the_user_should_receive_an_alert_that_reads(String string) {
        new WebDriverWait(driver, 9)
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/main[2]/div/form/div/div[4]/div[1]/div/div/div[2]")));
        Assertions.assertNotNull(driver.findElement(By.xpath("/html/body/div/main[2]/div/form/div/div[4]/div[1]/div/div/div[2]")).getText());
    }


    @When("the user types {string} into the Card Number Field")
    public void theUserTypesIntoTheCardNumberField(String arg0) {
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys("PassPass#1");
        WebElement cardNumberInput = driver.findElement(By.xpath("//input[@id='cardNumber']"));
        cardNumberInput.sendKeys(arg0);
    }

    @When("the user types {string} into the CVV field")
    public void theUserTypesIntoTheCVVField(String arg0) {
        WebElement cVVInput = driver.findElement(By.xpath("//input[@id='ccv']"));
        cVVInput.sendKeys(arg0);
    }

    @When("the user clicks on the Add Payment Button")
    public void theUserClicksOnTheAddPaymentButton() {
        WebElement addPaymentButton = driver.findElement(By.xpath("/html/body/div/main[1]/div/form/div/div[3]/div[2]/button"));
        addPaymentButton.click();
    }

    @Then("the user should receive the alert that reads {string}")
    public void theUserShouldReceiveTheAlertThatReads(String arg0) {
        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/main[2]/div/form/div/div[4]/div[1]/div/div/div[2]")));
        Assertions.assertNotNull(driver.findElement(By.xpath("/html/body/div/main[2]/div/form/div/div[4]/div[1]/div/div/div[2]")).getText());
    }

    @When("the user types {string} {string} {string} into the Date Field")
    public void theUserTypesIntoTheDateField(String arg0, String arg1, String arg2) {
        WebElement dateInput = driver.findElement(By.xpath("//input[@id='expDate']"));
        dateInput.sendKeys(arg0);
        dateInput.sendKeys(arg1);
        dateInput.sendKeys(arg2);
    }
}
