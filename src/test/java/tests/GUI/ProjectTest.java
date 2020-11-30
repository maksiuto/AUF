package tests.GUI;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LoginSteps;
import steps.ProjectSteps;

public class ProjectTest extends BaseTest {
    private ProjectSteps projectSteps;
    private LoginSteps loginSteps;

    @Test(description = "Создание проекта")
    public void createProject() {
     projectSteps = new ProjectSteps(driver);
     loginSteps.login(readProperties.getUserName(), readProperties.getPassword());
     projectSteps.create("Mike");
     Assert.assertTrue(true);
    }

    @Test(description = "Изменение проекта")
    public void editProject() {
        projectSteps = new ProjectSteps(driver);
        projectSteps.edit("Mike edit");
        Assert.assertTrue(true);
    }

    @Test(description = "Удаление проекта")
    public void deleteProject() {
        projectSteps = new ProjectSteps(driver);
        projectSteps.delete();
        Assert.assertTrue(true);
    }
}
