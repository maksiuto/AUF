package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.file.WatchEvent;

public class DeletePage extends BasePage {

    private static String ENDPOINT = "/admin/projects/overview";
    private static By DELETE_BUTTON = By.xpath("//div[@class='icon-small-delete']");
    private static By CHECKBOX_BUTTON = By.xpath("//span[@class='dialog-confirm-busy']/following::input");
    private static By OK_BUTTON = By.xpath("//*[@class='icon-progress-inline']/following::a[1]");

    public DeletePage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        return waiters.isElementDisplayed(DELETE_BUTTON);
    }

    private WebElement getDeleteButton() {
        return waiters.getElementBy(DELETE_BUTTON);
    }

    private WebElement getCheckbox() {
        return waiters.getElementBy(CHECKBOX_BUTTON);
    }

    private WebElement getOkButton() {
        return waiters.getElementBy(OK_BUTTON);
    }

    public void setDeleteButton() {
        getDeleteButton().click();
    }

    public void setCheckboxButton() {
        getCheckbox().click();
    }

    public void setOkButton() {
        getOkButton().click();
    }
}
