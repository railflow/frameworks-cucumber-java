package io.railflow.frameworks.cucumber.java;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps extends TestBase {

    @Given("User navigates to the login page")
    public void user_navigates_to_the_login_page() {
        driver().get("https://www.saucedemo.com/");
    }

    @When("^User enters the username \"([\\w\\s\"']*)\"")
    public void user_enters_the_username(final String username) {
        driver().findElement(By.id("user-name")).sendKeys(username);
    }

    @When("^User enters the password \"([\\w\\s\"']*)\"")
    public void user_enters_the_password(final String password) {
        driver().findElement(By.id("password")).sendKeys(password);
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        driver().findElement(By.id("login-button")).click();
    }

    @Then("User should navigate to the home page")
    public void user_should_navigate_to_the_home_page() {
		assertTrue(driver().findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed());
    }
}
