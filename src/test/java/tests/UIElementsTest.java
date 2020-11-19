package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import steps.LoginSteps;
import wrappers.*;

public class UIElementsTest extends BaseTest {


    @Test
    public void tableTest (){
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        driver.get("https://aqa071.testrail.io/index.php?/admin/projects/overview");

        Table table = new Table(driver, By.cssSelector("table.grid"));
        table.clickItemInRow(1);

    }



}
