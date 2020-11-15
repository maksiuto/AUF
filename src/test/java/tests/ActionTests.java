package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import steps.LoginSteps;
import sun.rmi.runtime.Log;

public class ActionTests extends BaseTest {

    @Test
    public void clickBottomLink(){
        LoginSteps loginSteps = new LoginSteps(driver);
//        loginSteps.login(readProperties.getUserName(),

    }
}
