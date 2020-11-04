import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginSteps;
import utils.Retry;

public class MainTest extends BaseTest {
    private LoginSteps loginSteps;

    @Test
    public void loginPositiveTest(){
        loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        Assert.assertTrue(true);
    }

    @Test(enabled = false)
    public void loginNegativeTest(){
        loginSteps = new LoginSteps(driver);
        loginSteps.login("fail", readProperties.getPassword());

        Assert.assertEquals(new LoginPage(driver, false).getErrorMessage().getText(),
                "Sorry, there was a problem.",
                "Incorrect message");
    }

    @DataProvider(name = "Набор креда")
    public Object[][] credentialsForTest (){
        return new Object[][] {
                {"atrostyanko+aqa07@gmail.com", "w3n1bU7F4rxOfnfvrBJL"},
                {"sdsd","w3n1bU7F4rxOfnfvrBJL"},
                {"atrostyanko+aqa07@gmail.com", "asdasd"}
        };
    }
    @Test(dataProvider = "Набор креда")
    public void testLoginWithMultipleCredentials(String usename, String psw) {
        loginSteps = new LoginSteps(driver);
        loginSteps.login(usename,psw);
    }

    @Parameters({"username", "psw"})
    @Test
    public void testLoginWithParametrs(@Optional("1") String usename, @Optional("2") String psw) {
        loginSteps = new LoginSteps(driver);
        loginSteps.login(usename,psw);
    }

    //@Test(retryAnalyzer = Retry.class)
    //public void retryTest(){
    //    throw new NullPointerException();

    //}
}
