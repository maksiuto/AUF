package tests.GUI;

import baseEntities.BaseTest;
import models.*;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectPage;
import steps.AdministrationStep;
import steps.LoginSteps;

public class PageFactoryTest extends BaseTest {

    @Test
    public void firstTest() {
        User user = new User(readProperties.getUserName(), readProperties.getPassword());
//        LoginPage loginPage = new LoginPage(driver, true);
//        loginPage.emailSelector.sendKeys();
//        loginPage.passwordSelector.sendKeys();
//        //ProjectPage projectPage = loginPage.clickLoginButton();
//        //projectPage.clickAddProjectButton();

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(user);

        Project project = new Project("Main project", "Test", true, 1, false);

        ProjectBuilder projectBuilder = ProjectBuilder.newBuilder()
                .setName("")
                .setAnnouncement("")
                .build();

//        Account account = new Account().newBuilder()
//                .setToken("hello")
//                .setUserId("habr")
//                .build();

        AdministrationStep administrationStep = new AdministrationStep();
        administrationStep.updateProject(project);
    }

    @Test
    public void secondTest() {
        TestCase testCase = new TestCase.Builder()
                .withTitle("Title 1")
                .withReference("AQA1")
                .build();
        testCase.getTitle();
    }
}
