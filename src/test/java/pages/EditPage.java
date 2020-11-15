package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditPage extends BasePage {

    private static String ENDPOINT = "/admin/projects/overview";

    private static By EDIT_BUTTON = By.xpath("//div[@class='icon-small-edit']");
    private static By CHANGE_FIELD = By.xpath("//textarea[@name='announcement']");
    private static By SAVE_CHANGES_BUTTON = By.xpath("//button[@id='accept']");

    public EditPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

        @Override
        protected void openPage() {
            driver.get(BASE_URL + ENDPOINT);
        }

        @Override
        public boolean isPageOpened() {
            return waiters.isElementDisplayed(EDIT_BUTTON);
    }

    private WebElement getEditButton() {
        return waiters.getElementBy(EDIT_BUTTON);
    }

    private WebElement getChangeField() {
        return waiters.getElementBy(CHANGE_FIELD);
    }

    private WebElement getSaveChangesButton() {
        return waiters.getElementBy(SAVE_CHANGES_BUTTON);
    }

    public void setEditButton() {
        getEditButton().click();
    }

    public void setChangeField(String text) {
        getChangeField().sendKeys(text);
    }

    public void setSaveChangesButton() {
        getSaveChangesButton().submit();
    }
}
