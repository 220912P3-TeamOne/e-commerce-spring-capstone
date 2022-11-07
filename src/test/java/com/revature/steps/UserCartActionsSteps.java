package com.revature.steps;

import com.revature.runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class UserCartActionsSteps {
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
    @Then("User should see available products on Homepage and sees logout button")
    public void user_should_see_available_products_on_homepage_and_sees_logout_button() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver,8);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[3]/div[1]")));
        WebElement logout = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong"));
        Assertions.assertNotNull(logout);
        boolean products=driver.findElement(By.xpath("/html/body/div/div[3]/div[1]")).isDisplayed();
        System.out.println("Products displayed : "+products);
    }
    @Then("User should see available products on Homepage")
    public void user_should_see_available_products_on_homepage() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost:3000/");
        WebDriverWait wait = new WebDriverWait(driver,8);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[3]/div[1]")));
        boolean products=driver.findElement(By.xpath("/html/body/div/div[3]/div[1]")).isDisplayed();
        System.out.println("Products displayed : "+products);
    }

    @When("User Hovers over to product and adds product to the cart")
    public void user_hovers_over_to_product_and_adds_product_to_the_cart() {
        // Write code here that turns the phrase above into concrete actions
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,8);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[3]/div[1]/div/div[1]/div[1]")));
        WebElement addproduct=driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/div/div[1]/div[1]"));
        actions.moveToElement(addproduct).perform();
        addproduct.click();
    }

    @When("User clicks on cart icon")
    public void user_clicks_on_cart_icon() {
        // Write code here that turns the phrase above into concrete actions
        boolean logout = driver.findElements(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong")).size() >0;
        if(logout==true){
            WebElement logoutuser=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/li"));
            logoutuser.click();
            driver.get("http://localhost:3000/");
            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[2]/div[3]")));
        }
        WebElement cartpage=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[3]"));
        cartpage.click();
    }

    @When("User clicks on cart icon when logged in")
    public void user_clicks_on_cart_icon_when_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        WebElement cartpage=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[4]"));
        cartpage.click();
    }
    @Then("User is redirected to cart page")
    public void user_is_redirected_to_cart_page() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver,8);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/h1")));
        WebElement heading=driver.findElement(By.xpath("/html/body/div/div[2]/div/h1"));
        assertEquals("YOUR BAG",heading.getText());
    }

    @Then("User should see the product added to cart")
    public void user_should_see_the_product_added_to_cart() {
        // Write code here that turns the phrase above into concrete actions
        boolean products=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div")).isDisplayed();
        System.out.println("Products in Cart are displayed : "+products);
    }

    @When("User increses product quantity by {string}")
    public void user_increses_product_quantity_by(String string) {
        // Write code here that turns the phrase above into concrete actions
        boolean logout = driver.findElements(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong")).size() > 0;
        if(logout==true) {
            WebDriverWait wait = new WebDriverWait(driver, 8);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[3]/div[1]/div/div[1]/div[1]")));
            Actions actions = new Actions(driver);
            WebElement addproduct=driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/div/div[1]/div[1]"));
            actions.moveToElement(addproduct).perform();
            addproduct.click();
            WebElement cartpage=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[4]"));
            cartpage.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/button[3]")));
            WebElement quantityincrease = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/button[3]"));
            int count = Integer.parseInt(string);
            for (int i = 1; i <= count; i++) {
                quantityincrease.click();
            }
        }else{
            WebDriverWait wait = new WebDriverWait(driver, 8);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div")));
            WebElement quantityincrease = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/button[3]"));
            int count = Integer.parseInt(string);
            for (int i = 1; i <= count; i++) {
                quantityincrease.click();
            }
        }
    }

    @Then("User should see {string} in quantity")
    public void user_should_see_in_quantity(String string) {
        // Write code here that turns the phrase above into concrete actions

        WebElement Count=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div/div[2]/div[1]/div"));
        assertEquals(Count.getText(),string);
    }

    @When("User decreases product quantity by {string}")
    public void user_decreases_product_quantity_by(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement quantityincrease=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/button[1]"));
        int count=Integer.parseInt(string);
        for(int i=1;i<=count;i++){
            quantityincrease.click();
        }
    }

    @When("User clicks on delete")
    public void user_clicks_on_delete() {
        // Write code here that turns the phrase above into concrete actions
        boolean logout = driver.findElements(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong")).size() > 0;
        if(logout==true) {
            WebDriverWait wait = new WebDriverWait(driver, 8);
            //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[2]/div[4]")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[3]/div[1]/div/div[1]/div[1]")));
            Actions actions = new Actions(driver);
            WebElement addproduct=driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/div/div[1]/div[1]"));
            actions.moveToElement(addproduct).perform();
            addproduct.click();
            WebElement cartpage = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[4]"));
            cartpage.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/button[2]")));
            WebElement deleteitem = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/button[2]"));
            deleteitem.click();
        }else{
            WebDriverWait wait = new WebDriverWait(driver, 8);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div")));
            WebElement deleteitem = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/button[2]"));
            deleteitem.click();
        }
    }


    @Then("User should not see the product inside the cart")
    public void user_should_not_see_the_product_inside_the_cart() {
        // Write code here that turns the phrase above into concrete actions
        boolean logout = driver.findElements(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong")).size() > 0;
        if(logout==true) {
            boolean products = driver.findElements(By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div")).size()>0;
            System.out.println("Products in Cart are displayed : " + products);
            WebElement logoutbutton = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong"));
            logoutbutton.click();

        }else{
            boolean products = driver.findElements(By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div")).size()>0;
            System.out.println("Products in Cart are displayed : " + products);
        }
    }

}
