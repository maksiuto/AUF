package tests.GUI;

import models.ProjectLambokBuilder;
import models.TestCaseLambok;
import org.testng.annotations.Test;

public class ProjectLambokBuilderTest {

    @Test
    public void Test() {
        ProjectLambokBuilder projectLambokBuilder = ProjectLambokBuilder.builder()
                .name("Test")
                .build();

        System.out.println(projectLambokBuilder.getAnnouncement());
        System.out.println(projectLambokBuilder.getName());
        System.out.println(projectLambokBuilder.hashCode());

    }
}
