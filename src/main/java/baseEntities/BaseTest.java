package baseEntities;

import browserService.BrowserService;
import browserService.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.Listener;

import java.util.concurrent.TimeUnit;

@Listeners(Listener.class)
public class BaseTest {
    public WebDriver driver;
    public ReadProperties readProperties = new ReadProperties();


    //public void BaseTest() {}

    @BeforeClass
    public void setUp() {
        this.driver = new BrowserService().getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(new ReadProperties().getURL());

    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }
}

