package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


public class AccountPage {
    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Discover")
    WebElement discoverLink;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(id = "display_name")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(className = "tw-text-primary")
    WebElement welcomeMsg;

    @FindBy(className = "css-17u1wwn")
    WebElement forgotPassword;

    public void fillEmail(String email){
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void fillUserName(String userName){
        userNameField.clear();
        userNameField.sendKeys(userName);
    }

    public void fillPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void submitButton(){
        submitButton.click();
    }

    public void clickForgotPassword(){
        forgotPassword.click();
    }

    public String getWelcomeMsg(){
        String welcomeText = welcomeMsg.getText();
        return welcomeText;
    }
}