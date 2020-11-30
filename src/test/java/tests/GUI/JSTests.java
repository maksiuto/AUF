package tests.GUI;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.ProjectPage;
import steps.LoginSteps;

import java.util.concurrent.TimeUnit;

public class JSTests extends BaseTest {

    @Test
    public void moveToElementTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        driver.get("https://aqa0702.testrail.io/index.php?/cases/edit/2/1");

        ProjectPage projectPage = new ProjectPage(driver, false);
        //projectPage.clickAddProjectButton();
    }
}
