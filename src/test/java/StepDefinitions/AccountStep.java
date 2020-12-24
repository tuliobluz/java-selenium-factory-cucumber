package StepDefinitions;

import Utils.BrowserClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

import Pages.AccountPage;


public class AccountStep {

    String BASE_URL = "https://www.komoot.com/";
    String REGISTER_URL = "https://account.komoot.com";
    String EXPECTED_WELCOME = "Welcome | Komoot";
    String EXPECTED_WELCMSG = "HershelHerzog, your next adventure starts now!";
    String registeredEmail = "HershelHerzog_STAGE@gmail.com";
    String registeredPassword = "HershelHerzog@2020";

    BrowserClass sbc = BrowserClass.getInstanceOfSingletonBrowserClass();
    WebDriver driver = sbc.getDriver();

    AccountPage accountPage;
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = firstName + lastName + "_STAGE@gmail.com";

    @AfterSuite
    public void tearDown(){
        driver.close();
    }

    @Given("The user is on the register page")
    public void the_user_is_on_the_register_page() {
        driver.get(REGISTER_URL + "/signin");
    }

    @When("The user fills the field")
    public void the_user_fills_the_field() {
        System.out.println(email);

        accountPage = new AccountPage(driver);
        accountPage.fillEmail(email);
        accountPage.submitButton();

        accountPage.fillUserName(firstName + " " +lastName);
        accountPage.fillPassword(firstName + lastName + "@2020");
    }

    @When("The user submits")
    public void the_user_submits() {
        accountPage = new AccountPage(driver);
        accountPage.submitButton();
    }

    @When("The user goes to forgot password")
    public void the_user_goes_to_forgot_password() {
        accountPage = new AccountPage(driver);
        accountPage.fillEmail(registeredEmail);
        accountPage.clickForgotPassword();
        accountPage.submitButton();
    }

    @Then("The user should see the welcome message")
    public void the_user_should_see_the_welcome_message() {
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        accountPage = new AccountPage(driver);
        String welcomeMsg = accountPage.getWelcomeMsg();

        Assert.assertEquals(title, EXPECTED_WELCOME);
        Assert.assertEquals(url, BASE_URL + "/onboarding/signup/intro");
        Assert.assertEquals(welcomeMsg, EXPECTED_WELCMSG);
    }
}
