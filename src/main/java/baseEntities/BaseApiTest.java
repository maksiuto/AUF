package baseEntities;

import browserService.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;
import utils.Listener;
import org.testng.annotations.Listeners;

import static io.restassured.RestAssured.given;

//@Listeners(Listeners.class)
public abstract class BaseApiTest {
    public ReadProperties properties;
    String  username;
    String psw;
    @BeforeTest
    public void setUp() {
        properties = new ReadProperties();

        RestAssured.baseURI =  properties.getApiURL();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(properties.getUserName(), properties.getPassword());
    }

}
