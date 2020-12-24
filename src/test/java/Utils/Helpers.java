package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {

    int TIMEOUT = 30;

    public void waitTextToBePreset(WebElement element, String text, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    public void waitElementToBePreset(WebElement element, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf((element)));
    }
}