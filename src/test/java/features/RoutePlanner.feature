Feature: Route Planner
  In order to manage routes
  As a guest or registered user
  The user will be able to manage the routes

  Background:
    Given The user is on the Route Planner Page

  Scenario: Create a new route
    Given The user fills the start point and the end point
    When The user submits the plan
    Then The user should see the list of options

  Scenario: Edit a route
    Given The user has already planned the route
    When The user changes the destination
    And The user submits the plan
    Then The user should see the list of options updated

  Scenario: Added a new destination
    Given The user has already planned the route
    When The user adds a new destination
    And The user submits the plan
    Then The user should see the list of options updated