package com.revature.steps;

import com.revature.runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPageSteps {

    public static ChromeDriver driver = Runner.driver;

    @Given("a user is logged in.")
    public void a_user_is_logged_in() {
        WebDriverWait wait = new WebDriverWait(driver,(7));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div/div[2]/div[2]/strong")));
        WebElement signIn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[2]/strong"));
        signIn.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/main/div/form/div[1]/div/input")));
        WebElement username = driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div/input"));
        username.sendKeys("team1@testing.com");

        WebElement password = driver.findElement(By.xpath("/html/body/div/main/div/form/div[2]/div/input"));
        password.sendKeys("team1");

        WebElement signInButton = driver.findElement(By.xpath("/html/body/div/main/div/form/button"));
        signInButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong")));



    }
    @When("a user clicks on edit products")
    public void a_user_clicks_on_edit_products() {
    WebElement editProducts = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[1]/strong"));
    editProducts.click();
    }
    @When("the user clicks on create new product")
    public void the_user_clicks_on_create_new_product() {
        WebDriverWait wait = new WebDriverWait(driver,7);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div/button")));
    WebElement createNew = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/button"));
    createNew.click();
    }
    @When("a user enters a product name")
    public void a_user_enters_a_product_name() {
        WebDriverWait wait = new WebDriverWait(driver,7);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div/div[2]/div/input")));
        WebElement productName = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div/input"));
        productName.sendKeys("Surf Board");

    }
    @When("a user enters a product description")
    public void a_user_enters_a_product_description() {
    WebElement description = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[3]/div/input"));
    description.sendKeys("It is a surf board");
    }
    @When("a user enters an image URL")
    public void a_user_enters_an_image_url() {
    WebElement url = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[4]/div/input"));
    url.sendKeys("1234");
    }
    @When("a user enters a product price")
    public void a_user_enters_a_product_price() {
        WebElement price = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[5]/div/input"));
        price.sendKeys("25.99");

    }
    @When("a user clicks create product")
    public void a_user_clicks_create_product() {
        WebElement productButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/button"));
        productButton.click();

    }
    @Then("the user should be on the update product page.")
    public void the_user_should_be_on_the_update_product_page() {
        WebDriverWait wait = new WebDriverWait(driver,7);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div/div[2]/h3")));
    WebElement header = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/h3"));
    String comparison = header.getText();
    Assertions.assertEquals("Surf Board", comparison);

    }


}
