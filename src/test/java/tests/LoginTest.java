package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginSteps;

public class LoginTest extends BaseTest {
    private LoginSteps loginSteps;

    @Test
    public void positiveLogin(){
        loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        Assert.assertTrue(true);
    }

    @Test
    public void firstNegativeLogin(){
        loginSteps = new LoginSteps(driver);
        loginSteps.login("fail", readProperties.getPassword());

        Assert.assertEquals(new LoginPage(driver, false).getErrorMessage().getText(),
                "Sorry, there was a problem.",
                "Incorrect credentials");
    }

    @Test
    public void secondNegativeLogin(){
        loginSteps =new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(),"fail");

        Assert.assertEquals(new LoginPage(driver, false).getErrorMessage().getText(),
                "Sorry, there was a problem.",
                "Incorrect credentials");
    }

    @Test
    public void thirdNegativeLogin(){
        loginSteps = new LoginSteps(driver);
        loginSteps.login("fail", "fail");

        Assert.assertEquals(new LoginPage(driver, false).getErrorMessage().getText(),
                "Sorry, there was a problem.",
                "Incorrect credentials");
    }
}
