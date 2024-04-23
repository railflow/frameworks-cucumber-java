@logout
Feature: Logout from the Swag Labs site
    User wants to logout from the Swag Labs site

    @logout-success
        Scenario: Logout after logging in
            Given User is logged in with username <Username> and password <Password>
            And User navigates to the left side bar
            When User clicks on the logout button
            Then User should be logged out

        @testrail.id=C2279
        Examples: 
        |Username|Password|
        |"standard_user"|"secret_sauce"|

        @testrail.id=C2280
        Examples: 
        |Username|Password|
        |"problem_user"|"secret_sauce"|

        @testrail.id=C2281
        Examples: 
        |Username|Password|
        |"performance_glitch_user"|"secret_sauce"|
