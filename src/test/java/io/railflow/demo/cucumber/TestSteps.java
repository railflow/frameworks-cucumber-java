package io.railflow.demo.cucumber;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps extends TestBase {

    @Given("User navigates to the login page")
    public void user_navigates_to_the_login_page() {
        driver().get("https://www.saucedemo.com/");
    }

    @When("User enters the username {string}")
    public void user_enters_the_username(final String username) {
        driver().findElement(By.id("user-name")).sendKeys(username);
    }

    @When("User enters the password {string}")
    public void user_enters_the_password(final String password) {
        driver().findElement(By.id("password")).sendKeys(password);
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        driver().findElement(By.id("login-button")).click();
    }

    @Then("User should navigate to the home page")
    public void user_should_navigate_to_the_home_page() {
        final WebElement element = assertDoesNotThrow(() ->
            driver().findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")));

        assertNotNull(element);
        assertTrue(element.isDisplayed());
    }

    @Then("User should not navigate to the home page")
    public void user_should_not_navigate_to_the_home_page() {
        assertThrows(NoSuchElementException.class, () ->
            driver().findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")));
    }

    @Then("User should see the login error {string}")
    public void user_should_see_the_login_error_message(final String error) {
        final WebElement element = assertDoesNotThrow(() ->
            driver().findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")));

        assertNotNull(element);
        assertEquals(error, element.getAttribute("innerText"));
    }

    @Given("User is logged in with username {string} and password {string}")
    public void user_is_logged_in_with_username_and_password(final String username, final String password) {
        user_navigates_to_the_login_page();
        user_enters_the_username(username);
        user_enters_the_password(password);
        user_clicks_the_login_button();
        user_should_navigate_to_the_home_page();
    }

    @Given("User navigates to the left side bar")
    public void user_navigates_to_the_left_side_bar() {
        driver().findElement(By.id("react-burger-menu-btn")).click();
        sleep(100);
    }

    @When("User clicks on the logout button")
    public void user_clicks_on_the_logout_button() {
        driver().findElement(By.linkText("Logout")).click();
    }

    @Then("User should be logged out")
    public void user_should_be_logged_out() {
        assertThrows(NoSuchElementException.class, () ->
            driver().findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")));
    }

    private void sleep(final int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
