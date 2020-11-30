package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectPage extends BasePage {

    private static String ENDPOINT = "/dashboard";

    private static By NEW_PROJECT_BUTTON = By.className("sidebar-button");
    private static By NAME_FIELD = By.id("name");
    private static By ADD_PROJECT_BUTTON = By.id("accept");

    public ProjectPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage()  {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        return waiters.isElementDisplayed(By.id("sidebar-button"));
    }

    private WebElement getNewProjectButton() {
        return waiters.getElementBy(NEW_PROJECT_BUTTON);
    }

    private WebElement getNameField() {
        return waiters.getElementBy(NAME_FIELD);
    }

    public WebElement getAddProjectButton() {
        return waiters.getElementBy(ADD_PROJECT_BUTTON);
    }

    public void setNewProjectButton() {
        getNewProjectButton().click();
    }

    public void setNameField(String name) {
        getNameField().sendKeys(name);
    }

    public void setAddProjectButton() { getAddProjectButton().submit(); }

    public void clickAddProjectButton() {
        WebElement webElement = getAddProjectButton();
//        Actions actions = new Actions(driver);
//        actions.moveToElement(webElement).click().build().perform();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true)", webElement);
        webElement.click();
    }
}
