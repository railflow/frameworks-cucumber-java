@login
Feature: Login to Swag labs site
    User wants to login to the Swag Labs site

    @login-success
    Scenario: Login to the site with valid credentials
        Given User navigates to the login page
        When User enters the username <Username>
        And User enters the password <Password>
        And User clicks the login button
        Then User should navigate to the home page

        @testrail.id=C2258
        Examples: 
        |Username|Password|
        |"standard_user"|"secret_sauce"|

        @testrail.id=C2259        
        Examples: 
        |Username|Password|
        |"locked_out_user"|"secret_sauce"|

        @testrail.id=C2260        
        Examples: 
        |Username|Password|
        |"problem_user"|"secret_sauce"|

        @testrail.id=C2261        
        Examples: 
        |Username|Password|
        |"performance_glitch_user"|"secret_sauce"|

    @login-failure
    Scenario: Login to the site with invalid credentials
        Given User navigates to the login page
        When User enters the username <Username>
        And User enters the password <Password>
        And User clicks the login button
        Then User should not navigate to the home page

        @testrail.id=C2262
        Examples: 
        |Username|Password|
        |"standard_user"|""|

        @testrail.id=C2263
        Examples: 
        |Username|Password|
        |"standard_user"|" "|

        @testrail.id=C2264
        Examples: 
        |Username|Password|
        |"standard_user"|"invalid_password"|

        @testrail.id=C2265
        Examples: 
        |Username|Password|
        |""|"secret_sauce"|

        @testrail.id=C2266
        Examples: 
        |Username|Password|
        |" "|"secret_sauce"|

        @testrail.id=C2267
        Examples: 
        |Username|Password|
        |"invalid_user"|"secret_sauce"|
