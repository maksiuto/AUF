package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrappers.UIElement;

public class LoginPage extends BasePage {

    private static String ENDPOINT = "/auth/login/";

    @FindBy(id ="name")
    public WebElement emailSelector;

    @FindBy(id = "password")
    public WebElement passwordSelector;

    @FindBy(id = "button_primary")
    public WebElement loginSelector;

    @FindBy(id = "error-on-top")
    public WebElement ERROR_MESSAGE_Selector;

    public LoginPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    public boolean isPageOpened() {
        return loginSelector.isDisplayed();
    }

    public ProjectPage clickLoginButton() {
         loginSelector.click();
         return new ProjectPage(driver, false);
    }

}
