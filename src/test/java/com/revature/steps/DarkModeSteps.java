package com.revature.steps;

import com.revature.runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
            WebDriverWait wait=new WebDriverWait(driver,8);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/span/span[1]/span[1]/input")));
            WebElement switchTrack = driver.findElement
                    (By.xpath("/html/body/div/div/div/div[2]/span/span[1]/span[1]/input"));
            switchTrack.click();
            switchTrack.click();
        }

        @Then("color scheme changes from normal mode to dark mode")
        public void color_scheme_changes_from_normal_mode_to_dark_mode () {
            // Write code here that turns the phrase above into concrete actions
            WebElement body=driver.findElement(By.tagName("body"));
            WebDriverWait wait =new WebDriverWait(driver,8);
            wait.until(ExpectedConditions.attributeToBe(body,"background-color","rgba(18, 18, 18, 1)"));
            System.out.println("Background changed to : "+body.getCssValue("background-color"));
            WebElement switchTrack = driver.findElement
                    (By.xpath("/html/body/div/div/div/div[2]/span/span[1]/span[1]/input"));
            switchTrack.click();
            System.out.println("Background changed to : "+body.getCssValue("background-color"));
        }
    }