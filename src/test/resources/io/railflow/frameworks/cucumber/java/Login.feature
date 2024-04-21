Feature: Login to Swag labs site
    User wants to login to the Swag Labs site

    Scenario: Login to the site with valid credentials
        Given User navigates to the login page
        When User enters the username <Username>
        And User enters the password <Password>
        And User clicks the login button
        Then User should navigate to the home page
        
        Examples: 
        |Username|Password|
        |"standard_user"|"secret_sauce"|
        |"locked_out_user"|"secret_sauce"|
        |"problem_user"|"secret_sauce"|
        |"performance_glitch_user"|"secret_sauce"|
