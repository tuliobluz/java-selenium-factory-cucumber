package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

import Pages.AccountPage;
import Utils.Helpers;
import Utils.ConfigFileReader;

public class AccountStep {

    ConfigFileReader configFileReader;

    String EXPECTED_WELCOME = "Welcome | Komoot";
    String EXPECTED_WELCMSG = "HershelHerzog, your next adventure starts now!";
    String EXPECTED_RESETMSG = "Your Password Has Been Reset";

    AccountPage accountPage;
    Faker faker = new Faker();
    Helpers helpers = new Helpers();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = firstName + lastName + "_STAGE@gmail.com";

    public WebDriver driver;
    public AccountStep() {
        driver = Hooks.driver;
    }

    @Given("The user is on the register page")
    public void the_user_is_on_the_register_page() {
        ConfigFileReader configFileReader = new ConfigFileReader();
        driver.get(configFileReader.getAttributes("REGISTER_URL") + "/signin");
    }

    @When("The user fills the field")
    public void the_user_fills_the_field() {
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
        configFileReader= new ConfigFileReader();
        accountPage.fillEmail(configFileReader.getAttributes("REGISTERED_USER"));
        accountPage.submitButton();
        accountPage.clickForgotPassword();
    }

    @When("The user fills the reset field")
    public void the_user_fills_the_reset_field() {
        accountPage = new AccountPage(driver);
        configFileReader= new ConfigFileReader();
        accountPage.fillEmail(configFileReader.getAttributes("REGISTERED_USER"));
    }

    @Then("The user should see the welcome message")
    public void the_user_should_see_the_welcome_message() {
        configFileReader= new ConfigFileReader();
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        accountPage = new AccountPage(driver);
        String welcomeMsg = accountPage.getWelcomeMsg();

        Assert.assertEquals(title, EXPECTED_WELCOME);
        Assert.assertEquals(url, configFileReader.getAttributes("BASE_URL") + "/onboarding/signup/intro");
        Assert.assertEquals(welcomeMsg, EXPECTED_WELCMSG);
    }

    @Then("The user should see the reset password message")
    public void the_user_should_see_the_reset_password_message() {
        accountPage = new AccountPage(driver);
        helpers.waitTextToBePreset(accountPage.resetMsg, EXPECTED_RESETMSG, driver);

        String resetMsg = accountPage.getResetMsg();
        Assert.assertEquals(resetMsg, EXPECTED_RESETMSG);
    }
}
