package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.DeletePage;
import pages.EditPage;
import pages.ProjectPage;

public class ProjectSteps {
    private WebDriver driver;

    public ProjectSteps (WebDriver driver) {
        this.driver = driver;
    }
    
    @Step
    public void create (String name) {
        ProjectPage projectPage = new ProjectPage(driver, true);
        projectPage.setAddProjectButton();
        projectPage.setNameField(name);
        projectPage.setNewProjectButton();
    }

    @Step
    public void edit (String text) {
        EditPage editProjectPage = new EditPage(driver, true);
        editProjectPage.setEditButton();
        editProjectPage.setChangeField(text);
        editProjectPage.setSaveChangesButton();
    }

    @Step
    public void delete() {
        DeletePage deleteProjectPage = new DeletePage(driver, true);
        deleteProjectPage.setDeleteButton();
        deleteProjectPage.setCheckboxButton();
        deleteProjectPage.setOkButton();

    }
}
