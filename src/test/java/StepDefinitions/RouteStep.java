package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;

import Pages.RoutePage;
import Utils.Helpers;
import Utils.ConfigFileReader;

public class RouteStep {
    RoutePage routePage;
    ConfigFileReader configFileReader;
    Helpers helpers = new Helpers();
    public WebDriver driver;

    public RouteStep() {
        driver = Hooks.driver;
    }

    String STARTPOINT = "Berlin";
    String DESTINATION_B = "Potsdam";
    String DESTINATION_C = "Michendorf";

    @Given("The user is on the Route Planner Page")
    public void the_user_is_on_the_route_planner_page() {

        configFileReader= new ConfigFileReader();
        driver.get(configFileReader.getAttributes("BASE_URL") + "/plan");
    }

    @Given("The user fills the start point and the end point")
    public void the_user_fills_the_start_point_and_the_end_point() {

        routePage = new RoutePage(driver);
        helpers.waitElementToBePreset(routePage.map, driver);
        routePage.clickStartPoint();
        routePage.fillPlace(STARTPOINT);
        helpers.waitElementToBePreset(routePage.result, driver);
        routePage.clickResult();

        routePage.clickDestination();
        routePage.fillPlace(DESTINATION_B);
    }

    @When("The user submits the plan")
    public void the_user_submits_the_plan() {

        routePage = new RoutePage(driver);
        helpers.waitElementToBePreset(routePage.result, driver);
        routePage.clickResult();
    }

    @When("The user changes the destination")
    public void the_user_changes_the_destination() {

        routePage = new RoutePage(driver);
        routePage.clickDestination();
        routePage.fillPlace(DESTINATION_C);
    }

    @When("The user adds a new destination")
    public void the_user_adds_a_new_destination() {

        routePage = new RoutePage(driver);
        routePage.addDestination();
        routePage.fillPlace(DESTINATION_C);
    }

    @Then("The user should see the list of options")
    public void the_user_should_see_the_list_of_options() {

        routePage = new RoutePage(driver);
        helpers.waitElementToBePreset(routePage.listResult, driver);
    }
}
