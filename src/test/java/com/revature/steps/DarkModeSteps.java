package com.revature.steps;

import com.revature.runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DarkModeSteps {

    ChromeDriver driver = Runner.driver;

    @Given("a user is on the logged in.")
    public void a_user_is_on_the_login_page() {

        driver.get("http://localhost:3000/");


    }
        @When("User clicks on the Switch track")
        public void user_clicks_on_the_switch_track () {
            // Write code here that turns the phrase above into concrete actions

            WebElement switchTrack = driver.findElement
                    (By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/span"));
            switchTrack.click();
        }

        @Then("color scheme changes from normal mode to dark mode")
        public void color_scheme_changes_from_normal_mode_to_dark_mode () {
            // Write code here that turns the phrase above into concrete actions

            Assert.assertTrue(driver.findElement(
                    By.xpath("//*[@id=\"root\"]")).isDisplayed());

        }
    }