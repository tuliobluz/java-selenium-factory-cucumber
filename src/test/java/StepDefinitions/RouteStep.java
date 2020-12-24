package StepDefinitions;

import Pages.AccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

import Pages.RoutePage;
import Utils.Helpers;
import Utils.BrowserClass;

public class RouteStep {

    String BASE_URL = "https://www.komoot.com";
    String STARTPOINT = "Berlin";
    String DESTINATION_B = "Potsdam";
    String DESTINATION_C = "Michendorf";

    BrowserClass sbc = BrowserClass.getInstanceOfSingletonBrowserClass();
    WebDriver driver = sbc.getDriver();

    RoutePage routePage;
    Faker faker = new Faker();
    Helpers helpers = new Helpers();

    @Given("The user is on the Route Planner Page")
    public void the_user_is_on_the_route_planner_page() {
        driver.get(BASE_URL + "/plan");
    }

    @Given("The user fills the start point and the end point")
    public void the_user_fills_the_start_point_and_the_end_point() throws InterruptedException {
        routePage = new RoutePage(driver);
        Thread.sleep(6000);
        routePage.clickStartPoint();
        routePage.fillPlace(STARTPOINT);
        routePage.clickResult();

        routePage.clickDestination();
        routePage.fillPlace(DESTINATION_B);
    }

    @When("The user submits the plan")
    public void the_user_submits_the_plan() {
        routePage = new RoutePage(driver);
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