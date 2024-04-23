@footer @footer-links
Feature: Page footer links
    User wants to use the page footer links

    @footer-link-twitter
    @testrail.id=C2283
    Scenario: Page footer link for Twitter
        Given User is logged in with username "standard_user" and password "secret_sauce"
        When User clicks the Twitter icon
        Then User should navigate to the Swag Labs Twitter page

    @footer-link-linkedin
    @testrail.id=C2284
    Scenario: Page footer link for LinkedIn
        Given User is logged in with username "standard_user" and password "secret_sauce"
        When User clicks the LinkedIn icon
        Then User should navigate to the Swag Labs LinkedIn page
