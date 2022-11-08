package com.revature.steps;

import com.revature.runner.Runner;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;

public class UserNotification {
    ChromeDriver driver = Runner.driver;
    @Then("User clicks on checkout")
    public void user_clicks_on_checkout() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver,8);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div")));
        WebElement checkout=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/button"));
        checkout.click();
    }

    @Then("User enters {string} in firstname")
    public void user_enters_in_firstname(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver,8);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/main/div/form/div[1]/div[1]/div/div/input")));
        WebElement firstname=driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div[1]/div/div/input"));
        firstname.sendKeys(string);

    }

    @Then("User enters {string} in lastname")
    public void user_enters_in_lastname(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement lastname=driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div[2]/div/div/input"));
        lastname.sendKeys(string);
    }

    @Then("User enters {string} in address")
    public void user_enters_in_address(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement address=driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div[3]/div/div/input"));
        address.sendKeys(string);
    }

    @Then("User enters {string} in city")
    public void user_enters_in_city(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement city=driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div[5]/div/div/input"));
        city.sendKeys(string);
    }

    @Then("User enters {string} in state")
    public void user_enters_in_state(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver,8);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/main/div/form/div[1]/div[5]/div/div/input")));
        WebElement state=driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div[6]/div/div/input"));
        state.sendKeys(string);
    }

    @Then("User enters {string} in zip code")
    public void user_enters_in_zip_code(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement zipcode=driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div[7]/div/div/input"));
        zipcode.sendKeys(string);
    }

    @Then("User enters {string} in country")
    public void user_enters_in_country(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement countryname=driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div[8]/div/div/input"));
        countryname.sendKeys(string);
    }

    @Then("User clicks on next")
    public void user_clicks_on_next() {
        // Write code here that turns the phrase above into concrete actions
        WebElement next=driver.findElement(By.xpath("/html/body/div/main/div/form/div[2]/button"));
        next.click();
    }

    @Then("User selects Payment Method")
    public void user_selects_payment_method() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver,8);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/main/div/form/div/div/table/tr[1]/label/span[1]/input")));
        WebElement paymenmethodselect=driver.findElement(By.xpath("/html/body/div/main/div/form/div/div/table/tr[1]/label/span[1]/input"));
        paymenmethodselect.click();
    }

    @Then("User clicks on Submit Payment")
    public void user_clicks_on_submit_payment() {
        // Write code here that turns the phrase above into concrete actions
        WebElement submitpayment=driver.findElement(By.xpath("/html/body/div/main/div/form/div/button[1]"));
        submitpayment.click();
    }

    @Then("User clicks on Place order")
    public void user_clicks_on_place_order() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver,8);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/main/div/div[3]/button[2]")));
        WebElement placeholder=driver.findElement(By.xpath("/html/body/div/main/div/div[3]/button[2]"));
        placeholder.click();
    }

    @Then("User should see a order confirmation notification")
    public void user_should_see_a_order_confirmation_notification() {
        // Write code here that turns the phrase above into concrete actions
        boolean notification=driver.findElement(By.xpath("/html/body/div/main/div/h6")).isDisplayed();
        System.out.println("Notification Displayed :"+notification);
    }

}
