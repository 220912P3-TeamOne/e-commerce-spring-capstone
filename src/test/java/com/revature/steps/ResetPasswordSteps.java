package com.revature.steps;

import com.revature.runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ResetPasswordSteps {

    public static WebDriver driver = Runner.driver;
    @Given("the user is on the reset password page")
    public void the_user_is_on_the_reset_password_page() {
        //
    }

    @When("the user types in their email address")
    public void the_user_types_in_their_email_address() {
        //
    }

    @When("the user clicks on reset password link button")
    public void the_user_clicks_on_reset_password_link_button() {
        //
    }

    @Then("the user should receive a confirmation alert that they reset their password")
    public void the_user_should_receive_a_confirmation_alert_that_they_reset_their_password() {
        //
    }
}
