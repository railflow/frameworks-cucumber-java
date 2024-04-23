package io.railflow.demo.cucumber;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

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

    @Then("User should see the footer")
    public void user_should_see_the_footer() {
        final WebElement element = assertDoesNotThrow(() ->
            driver().findElement(By.xpath("/html/body/div/div/footer")));

        assertNotNull(element);
        assertTrue(element.isDisplayed());
    }

    @When("User clicks the Twitter icon")
    public void user_clicks_the_twitter_icon() {
        driver().findElement(By.linkText("Twitter")).click();
        sleep(2000);
    }

    @Then("User should navigate to the Swag Labs Twitter page")
    public void user_should_navigate_to_the_swag_labs_twitter_page() {
        final List<String> tabs = new ArrayList<> (driver().getWindowHandles());
        try {
            driver().switchTo().window(tabs.get(tabs.size() - 1));
            
            final WebElement element = assertDoesNotThrow(() ->
            driver().findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[1]/div[1]/div/div/div/div/div/div[2]/div/h2/div/div/div/div/span[1]/span/span[1]")));
            
            assertNotNull(element);
            assertEquals("Sauce Labs", element.getAttribute("innerText"));
        } finally {
            driver().switchTo().window(tabs.get(0));
        }
    }

    @When("User clicks the LinkedIn icon")
    public void user_clicks_the_linkedin_icon() {
        driver().findElement(By.linkText("LinkedIn")).click();
        sleep(2000);
    }

    @Then("User should navigate to the Swag Labs LinkedIn page")
    public void user_should_navigate_to_the_swag_labs_linkedin_page() {
        final List<String> tabs = new ArrayList<> (driver().getWindowHandles());
        try {
            driver().switchTo().window(tabs.get(tabs.size() - 1));
            
            final WebElement element = assertDoesNotThrow(() ->
            driver().findElement(By.xpath("/html/body/main/section[1]/section/div/div[2]/div[1]/h1")));
            
            assertNotNull(element);
            assertEquals("Sauce Labs", element.getAttribute("innerText"));
        } finally {
            driver().switchTo().window(tabs.get(0));
        }
    }

    private void sleep(final int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
