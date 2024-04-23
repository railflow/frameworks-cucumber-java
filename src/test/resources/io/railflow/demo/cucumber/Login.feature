@login
Feature: Login to Swag Labs site
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
    Scenario: Login to the site with invalid username
        Given User navigates to the login page
        When User enters the username <Username>
        And User enters the password <Password>
        And User clicks the login button
        Then User should not navigate to the home page
        And User should see the login error <Error>

        @testrail.id=C2265
        Examples: 
        |Username|Password|Error|
        |""|"secret_sauce"|"Epic sadface: Username is required"|

        @testrail.id=C2266
        Examples: 
        |Username|Password|Error|
        |" "|"secret_sauce"|"Epic sadface: Username and password do not match any user in this service"|

        @testrail.id=C2267
        Examples: 
        |Username|Password|Error|
        |"invalid_user"|"secret_sauce"|"Epic sadface: Username and password do not match any user in this service"|

    @login-failure
    Scenario: Login to the site with invalid password
        Given User navigates to the login page
        When User enters the username <Username>
        And User enters the password <Password>
        And User clicks the login button
        Then User should not navigate to the home page
        And User should see the login error <Error>

        @testrail.id=C2262
        Examples: 
        |Username|Password|Error|
        |"standard_user"|""|"Epic sadface: Password is required"|

        @testrail.id=C2263
        Examples: 
        |Username|Password|Error|
        |"standard_user"|" "|"Epic sadface: Username and password do not match any user in this service"|

        @testrail.id=C2264
        Examples: 
        |Username|Password|Error|
        |"standard_user"|"invalid_password"|"Epic sadface: Username and password do not match any user in this service"|

    @login-failure
    Scenario: Login to the site with invalid username and password
        Given User navigates to the login page
        When User enters the username <Username>
        And User enters the password <Password>
        And User clicks the login button
        Then User should not navigate to the home page
        And User should see the login error <Error>

        @testrail.id=C2270
        Examples: 
        |Username|Password|Error|
        |""|""|"Epic sadface: Username is required"|

        @testrail.id=C2271
        Examples: 
        |Username|Password|Error|
        |""|" "|"Epic sadface: Username is required"|

        @testrail.id=C2272
        Examples: 
        |Username|Password|Error|
        |""|"invalid_password"|"Epic sadface: Username is required"|

        @testrail.id=C2273
        Examples: 
        |Username|Password|Error|
        |" "|""|"Epic sadface: Password is required"|

        @testrail.id=C2274
        Examples: 
        |Username|Password|Error|
        |" "|" "|"Epic sadface: Username and password do not match any user in this service"|

        @testrail.id=C2275
        Examples: 
        |Username|Password|Error|
        |" "|"invalid_password"|"Epic sadface: Username and password do not match any user in this service"|

        @testrail.id=C2276
        Examples: 
        |Username|Password|Error|
        |"invalid_user"|""|"Epic sadface: Password is required"|

        @testrail.id=C2277
        Examples: 
        |Username|Password|Error|
        |"invalid_user"|" "|"Epic sadface: Username and password do not match any user in this service"|

        @testrail.id=C2278
        Examples: 
        |Username|Password|Error|
        |"invalid_user"|"invalid_password"|"Epic sadface: Username and password do not match any user in this service"|
