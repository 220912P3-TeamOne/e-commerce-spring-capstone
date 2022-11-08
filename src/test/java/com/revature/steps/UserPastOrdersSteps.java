package com.revature.steps;

import com.revature.runner.Runner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPastOrdersSteps {
    ChromeDriver driver = Runner.driver;

    @Then("User clicks on orders")
    public void user_clicks_on_orders() {
        // Write code here that turns the phrase above into concrete actions

        WebDriverWait wait = new WebDriverWait(driver,8);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[2]/div[3]")));
        WebElement orders = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[3]"));
        orders.click();
    }

    @Then("User should see past orders")
    public void user_should_see_past_orders() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait=new WebDriverWait(driver,8);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[4]/div[1]")));
        boolean pastorders=driver.findElement(By.xpath("/html/body/div/div[4]/div[1]")).isDisplayed();
        System.out.println("Past Orders present: "+pastorders);
    }

}
