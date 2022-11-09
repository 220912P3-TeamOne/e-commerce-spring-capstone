package com.revature.steps;

import com.revature.runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsSteps {
    ChromeDriver driver = Runner.driver;
    @Given("The user has logged in")
    public void the_user_has_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost:3000/login");
        WebElement username = driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div/input"));
        username.sendKeys("team1@testing.com");
        WebElement password = driver.findElement(By.xpath("/html/body/div/main/div/form/div[2]/div/input"));
        password.sendKeys("team1");
        WebElement signInButton = driver.findElement(By.xpath("/html/body/div/main/div/form/button"));
        signInButton.click();
    }
    @When("User is on Homepage")
    public void user_is_on_homepage() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[3]/div[1]")));
        boolean logout = driver.findElements(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong")).size() >0;
        if(logout==true) {
            boolean productsavailable=driver.findElement(By.xpath("/html/body/div/div[3]/div[1]")).isDisplayed();
            System.out.println("Products available and User Logged In :"+productsavailable);
        }else{
            boolean productsavailable=driver.findElement(By.xpath("/html/body/div/div[3]/div[1]")).isDisplayed();
            System.out.println("Products available :"+productsavailable);
        }
    }

    @Then("User Hovers over to product and click on product details button")
    public void user_hovers_over_to_product_and_click_on_product_details_button() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[3]/div[1]/div/div[1]/div[2]/div")));
        boolean logout = driver.findElements(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong")).size() >0;
        if(logout==true) {
            Actions actions = new Actions(driver);
            WebElement viewdetails = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/div/div[1]/div[2]/div"));
            actions.moveToElement(viewdetails).perform();
            viewdetails.click();

        }else{
            Actions actions = new Actions(driver);
            WebElement viewdetails = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/div/div[1]/div[2]/div"));
            actions.moveToElement(viewdetails).perform();
            viewdetails.click();
        }
    }

    @Then("User should see product details")
    public void user_should_see_product_details() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[3]")));
        boolean description=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[3]")).isDisplayed();
        boolean logout = driver.findElements(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong")).size() >0;
        if(logout==true) {
            System.out.println("Description is Displayed :" + description);
            WebElement close = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/button[2]"));
            close.click();
            WebElement lout=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong"));
            lout.click();
            driver.get("http://localhost:3000/");
        }else{
            System.out.println("Description is Displayed :" + description);
            WebElement close = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/h2/button[2]"));
            close.click();
        }

    }

}
