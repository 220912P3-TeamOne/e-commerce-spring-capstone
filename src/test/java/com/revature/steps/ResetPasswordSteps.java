package com.revature.steps;

import com.revature.runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;

public class ResetPasswordSteps {

    public static WebDriver driver = Runner.driver;
    @Given("the user is on the reset password page")
    public void the_user_is_on_the_reset_password_page() {
        driver.get("http://localhost:3000/");
        //All the titles are the same???
        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.titleContains("Congo"));
        WebElement logout = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong"));
        Assertions.assertNotNull(logout);
        logout.click();
        WebElement signinLink = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[2]/strong"));
        signinLink.click();
        new WebDriverWait(driver, 7)
            .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div/main/div/form/div[3]/div[2]/a"))));
        WebElement resetLink = driver.findElement(By.xpath("/html/body/div/main/div/form/div[3]/div[2]/a"));
        resetLink.click();
    }

    @When("the user types in their email address")
    public void the_user_types_in_their_email_address() {
        WebElement emailInput = driver.findElement(By.xpath("//input[@id='email']"));
        emailInput.sendKeys("thisisacongoemail@gmail.com");
    }

    @When("the user clicks on reset password link button")
    public void the_user_clicks_on_reset_password_link_button() {
        WebElement resetPassLink = driver.findElement(By.xpath("/html/body/div/main/div/form/button"));
        resetPassLink.click();
    }

    @Then("the user should receive a confirmation alert that they reset their password")
    public void the_user_should_receive_a_confirmation_alert_that_they_reset_their_password() {
        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.alertIsPresent());
    }
}
