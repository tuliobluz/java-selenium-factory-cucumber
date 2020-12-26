package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoutePage {
    public RoutePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@data-position=0]/div/a")
    public WebElement startPoint;

    @FindBy(xpath = "//div[@data-position=1]/div/a")
    WebElement destination;

    @FindBy(className = "c-form-input")
    WebElement placeField;

    @FindBy(xpath = "//ul[@class='o-list-ui o-list-ui--separator']/li[1]")
    public WebElement result;

    @FindBy(className = "o-list-ui")
    public WebElement listResult;

    @FindBy(className = "icon-waypoint-add")
    WebElement iconAdd;

    @FindBy(className = "mapboxgl-canvas")
    public WebElement map;

    public void clickStartPoint(){
        startPoint.click();
    }

    public void clickDestination(){
        destination.click();
    }

    public void fillPlace(String place){
        placeField.clear();
        placeField.sendKeys(place);
    }

    public void clickResult(){
        result.click();
    }

    public void addDestination(){
        iconAdd.click();
    }

}
