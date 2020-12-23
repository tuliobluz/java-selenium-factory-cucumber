package StepDefinitions;

import Utils.BrowserClass;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import Pages.FirstPage;

public class FirstFeature {

    BrowserClass sbc = BrowserClass.getInstanceOfSingletonBrowserClass();
    WebDriver driver = sbc.getDriver();

    FirstPage firstPage;

    @After
    public void tearDown(){
        driver.close();
    }


    @Given("Launch the browser")
    public void launch_the_browser() {
        driver.get("https://www.komoot.com/");
        String Title = driver.getTitle();
        System.out.println(Title);

        firstPage = new FirstPage(driver);

        firstPage.clickDiscover();
    }

    @When("Hit Google on your browser")
    public void hit_google_on_your_browser() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Enter {string} in the search text box.")
    public void enter_in_the_search_text_box(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Select the first result.")
    public void select_the_first_result() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
