package com.revature.steps;

import com.revature.runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;

public class SearchSteps {
    public static ChromeDriver driver = Runner.driver;

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        driver.navigate().to("http://localhost:3000/");
    }

    @When("the user types the name of a product into the search bar")
    public void the_user_types_the_name_of_a_product_into_the_search_bar() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/input"))
                .sendKeys("yoyo");
        //intentionally wrong casing
    }

    @When("the user types a keyword of a product into the searchbar")
    public void the_user_types_a_keyword_of_a_product_into_the_search_bar() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/input"))
                .sendKeys("interesting");
    }

    @When("the user types a partial keyword of a product into the searchbar")
    public void the_user_types_a_partial_keyword_of_a_product_into_the_search_bar() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/input"))
                .sendKeys("xtremel");
    }

    @When("the user types a string unrelated to any product into the searchbar")
    public void the_user_types_a_string_unrelated_to_any_product_into_the_search_bar() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/input"))
                .sendKeys("xyz");
    }

    @When("the user enters return")
    public void the_user_enters_return() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/input"))
                .sendKeys(Keys.ENTER);
    }

    @Then("the user should see the product displayed")
    public void the_user_should_see_the_product_displayed() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[3]/div/div/div[2]/div")));
        WebElement product = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[2]/div"));
        Assertions.assertNotNull(product);
    }

    @Then("no products should be displayed")
    public void no_products_should_be_displayed() {

    }

}
