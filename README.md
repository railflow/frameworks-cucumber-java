# FRAMEWORKS-CUCUMBER-JAVA #

This project demonstrates the use of Railflow integration for TestRail in a Java project that uses Cucumber and Selenium, with Maven as the build tool. The tests cover various scenarios on the Sauce Demo website (https://www.saucedemo.com).

## Tools and Technologies ##

The following tools and technologies are used in this project.

- Java (1.8+): Programming language used for the automated test code.
- Maven (3.13.0): Build tool for Java.
- JUnit (5.10.2): Unit testing framework for Java.
- Cucumber (7.17.0): Behavior Driven Development (BDD) tool used for writing test scenarios.
- Selenium (4.19.1): Framework for browser automation for user interface tests.
- TestContainers (1.19.7): Container orchestration for Selenium and Chrome WebDriver.
- ChromeDriver: Web driver implementation for Chrome.
- Docker: Container platform.

## Building and Running Tests ##

Make sure you have Java, Maven, Docker and Chrome installed and setup.

You can build the project and execute the tests using the following command line.

    mvn clean test

This will build the project and execute all Cucumber tests. It also generates a test report in JSON format in `target/test-reports/cucumber.json` file.

## Uploading Test Results to TestRail ##

This can be done using the RailFlow CLI and required the following dependencies.

- NodeJS
- NPM

Install the RailFlow CLI as follows

    npm install railflow

You can then upload the Cucumber test report to your TestRail instance using the following command.

    npx railflow -k <license-key> -url <testrail-url> -u <testrail-username> -p <testrail-password> -pr <project-name> -path <test-path> -f cucumber -r target/test-reports/cucumber.json -sm name -tp <test-plan> -mp <milestone>
