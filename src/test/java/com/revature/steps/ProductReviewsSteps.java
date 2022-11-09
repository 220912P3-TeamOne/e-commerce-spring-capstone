package com.revature.steps;

import com.revature.runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductReviewsSteps {

    ChromeDriver driver = Runner.driver;

    @Given("The User is on the home page")
    public void the_user_is_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
//        WebDriverWait wait = new WebDriverWait(driver,(7));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div/div[2]/div[2]/strong")));
//        WebElement signIn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[2]/strong"));
//        signIn.click();
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/main/div/form/div[1]/div/input")));
//        WebElement username = driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div/input"));
//        username.sendKeys("team1@testing.com");
//
//        WebElement password = driver.findElement(By.xpath("/html/body/div/main/div/form/div[2]/div/input"));
//        password.sendKeys("team1");
//
//        WebElement signInButton = driver.findElement(By.xpath("/html/body/div/main/div/form/button"));
//        signInButton.click();

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong")));

        driver.get("http://localhost:3000/");

    }

    @When("The User hovers over a product card")
    public void the_user_hovers_over_a_product_card() {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().to("http://localhost:3000/");
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[3]/div[3]/div")));
        WebElement productCard  = driver.findElement(By.xpath("/html/body/div/div[3]/div[last()]/div"));

        Actions hover = new Actions(driver);
        hover.moveToElement(productCard).perform();

    }
    @When("The User clicks on the viewBox")
    public void the_user_clicks_on_the_view_box() {
        // Write code here that turns the phrase above into concrete actions

        WebElement viewBox = driver.findElement(By.xpath
                ("/html/body/div/div[3]/div[last()]/div/div[1]/div[2]/div"));

        Actions hover = new Actions(driver);
        hover.moveToElement(viewBox);
        hover.click().build().perform();

    }
    @Then("The User should be on the Product Reviews page")
    public void the_user_should_be_on_the_product_reviews_page() {
        // Write code here that turns the phrase above into concrete actions

        WebElement leaveAReview = driver.findElement(By.xpath
                ("/html/body/div[2]/div[3]/div/div[5]/h4"));
        Assertions.assertNotNull(leaveAReview);
        leaveAReview.click();

    }
    @When("The User clicks on a rating star")
    public void the_user_clicks_on_a_rating_star() {
        // Write code here that turns the phrase above into concrete actions
        WebElement ratingStar = driver.findElement(By.xpath
                ("/html/body/div[2]/div[3]/div/div[5]/span/label[5]"));
        ratingStar.click();

    }
    @When("The User clicks on the Product Review input")
    public void the_user_clicks_on_the_product_review_input() {
        // Write code here that turns the phrase above into concrete actions
        WebElement productReviewInput = driver.findElement(By.xpath
                ("/html/body/div[2]/div[3]/div/div[5]/div[1]/div"));
        productReviewInput.click();

    }
    @When("The User enters a comment")
    public void the_user_enters_a_comment() {
        // Write code here that turns the phrase above into concrete actions
        WebElement ReviewsInput = driver.findElement(By.xpath
                ("/html/body/div[2]/div[3]/div/div[5]/div[1]/div/textarea[1]"));
        ReviewsInput.sendKeys("wow");
    }
    @When("The user clicks on the Submit review button")
    public void the_user_clicks_on_the_submit_review_button() {
        // Write code here that turns the phrase above into concrete actions
        WebElement submitReviewButton = driver.findElement(By.xpath
                ("/html/body/div[2]/div[3]/div/div[5]/div[2]/button"));
        submitReviewButton.click();
    }
    @Then("A Reviews Card should be displayed with the name,rating and comment")
    public void a_reviews_card_should_be_displayed_with_the_name_rating_and_comment() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(10000);
        WebDriverWait wait = new WebDriverWait(driver,7);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[6]/div/div/div[1]/div")));
        Assert.assertTrue(driver.findElement(
                By.xpath("/html/body/div[2]/div[3]/div/div[6]/div/div/div[1]/div")).isDisplayed());

    }

    }

