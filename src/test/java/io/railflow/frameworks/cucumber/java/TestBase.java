package io.railflow.frameworks.cucumber.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;

public class TestBase {

    private static BrowserWebDriverContainer<?> container;
    private static WebDriver driver;

    static {
        container = new BrowserWebDriverContainer<>()
            .withCapabilities(new ChromeOptions());
        container.start();
        driver = new RemoteWebDriver(container.getSeleniumAddress(), new ChromeOptions());
    }

    protected WebDriver driver() {
        return driver;
    }
}