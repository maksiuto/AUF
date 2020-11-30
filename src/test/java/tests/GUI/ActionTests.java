package tests.GUI;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.ProjectPage;
import steps.LoginSteps;
import sun.rmi.runtime.Log;

import java.util.concurrent.TimeUnit;

public class ActionTests extends BaseTest {

    @Test
    public void clickBottomLink() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        ProjectPage projectPage = new ProjectPage(driver, false);
        projectPage.clickAddProjectButton();
    }

    @Test
    public void uploadTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement uploadInput = driver.findElement(By.xpath("//input[@type = 'file']"));
        uploadInput.sendKeys("C:/Users/maest/Downloads/abc.png");

        driver.findElement(By.id("file-submit")).click();
    }
}
