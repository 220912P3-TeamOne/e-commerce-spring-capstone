package com.revature.steps;

import com.revature.runner.Runner;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserRemoveAccount {
    ChromeDriver driver = Runner.driver;

    @Then("User redirects to profile page")
    public void user_redirects_to_profile_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost:3000/login");
        System.out.println(UserRegistrationSteps.iemailid);
        System.out.println(UserRegistrationSteps.ipassword);
        WebDriverWait wait = new WebDriverWait(driver,(8));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/main/div/form/div[1]/div/input")));
        WebElement username = driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div/input"));
        username.sendKeys(UserRegistrationSteps.iemailid);
        WebElement password = driver.findElement(By.xpath("/html/body/div/main/div/form/div[2]/div/input"));
        password.sendKeys(UserRegistrationSteps.ipassword);
        WebElement signInButton = driver.findElement(By.xpath("/html/body/div/main/div/form/button"));
        signInButton.click();

    }

    @Then("User enters {string}")
    public void user_enters(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait=new WebDriverWait(driver,8);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[2]/div[1]")));
        WebElement profilepage=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[1]"));
        profilepage.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[3]/div/div/div[1]/div/input")));
        WebElement input=driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[1]/div/input"));
        input.sendKeys(string);
    }

    @Then("User clicks on deactivate")
    public void user_clicks_on_deactivate() {
        // Write code here that turns the phrase above into concrete actions
        WebElement deactivate=driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[2]/button"));
        deactivate.click();
    }


}
