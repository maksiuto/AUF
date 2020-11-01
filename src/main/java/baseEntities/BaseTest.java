package baseEntities;

import browserService.BrowserService;
import browserService.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;
    public ReadProperties readProperties = new ReadProperties();


    //public void BaseTest() {}

    @BeforeClass
    public void SetUp() {
        this.driver = new BrowserService().getDriver();
        driver.get(new ReadProperties().getURL());

    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }
}

