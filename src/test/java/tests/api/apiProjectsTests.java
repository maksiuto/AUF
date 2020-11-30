package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import models.EndPoints;
import models.ProjectGson;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.ws.Endpoint;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class apiProjectsTests extends BaseApiTest {

    private int projectId;
    @Test
    public void addProject() {
        projectId = given()
                .body(String.format("{\n" +
                        "    \"name\": \"%s\"\n" +
                        "}", "Mike Aks Project"
                ))
        .when()
                .post(new EndPoints().addProject)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
        System.out.println(projectId);
    }

    @Test
    public void addProject2() {

        ProjectGson projectGson = ProjectGson.builder()
                .name("Mike Aks Project")
                .suite_mode(2)
                .build();
        Gson gson = new Gson();
        String json = gson.toJson(projectGson);
        System.out.println(json);

        projectId = given()
                .body(json)
                .when()
                .post(new EndPoints().addProject)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
        System.out.println(projectId);
    }

    @Test
    public void addProject3() {

        ProjectGson projectGson = ProjectGson.builder()
                .name("Mike Aks Project")
                .suite_mode(2)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", projectGson.getName());
        jsonAsMap.put("suite_mode", projectGson.getSuite_mode());

        System.out.println(jsonAsMap.toString());

        projectId =
                given()
                .body(jsonAsMap)
                .when()
                .post(new EndPoints().addProject)
                .then()
                .log()
                        .body()
                        .body("announcement", is(nullValue()))
                        .body("is_completed", is(false))
                        .body("completed_on", is(nullValue()))
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
        System.out.println(projectId);
    }

    //edit

    @Test
    public void addProject4() {

        ProjectGson exptectedProjectGson = ProjectGson.builder()
                .name("Mike Aks Project")
                .suite_mode(2)
                .build();
        Gson gson = new Gson();
        String json = gson.toJson(exptectedProjectGson);
        System.out.println(json);

        String actualJson =
                given()
                .body(json)
                .when()
                .post(new EndPoints().addProject).asString();

        System.out.println(actualJson);

        ProjectGson actualProject = gson.fromJson(actualJson, ProjectGson.class);

        projectId = actualProject.getId();
        System.out.println(projectId);
        Assert.assertEquals(actualJson, exptectedProjectGson);
    }
}
