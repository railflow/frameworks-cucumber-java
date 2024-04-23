@footer
@testrail.id=C2282
Feature: Page footer
    User wants the page footer to be displayed once logged in

    Scenario: Page footer should be displayed
        Given User is logged in with username "standard_user" and password "secret_sauce"
        Then User should see the footer
