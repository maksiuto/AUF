package tests.GUI;

import models.TestCase;
import models.TestCaseLambok;
import models.TestCaseLambokBuilder;
import org.testng.annotations.Test;

public class LombokTest {

    @Test
    public void firstTest() {
        TestCaseLambok testCaseLambok = new TestCaseLambok();
        testCaseLambok.setTitle("Test Title");
        String title = testCaseLambok.getTitle();

        System.out.println(title);
        System.out.println(testCaseLambok.toString());
        System.out.println(testCaseLambok.hashCode());
        System.out.println(testCaseLambok.equals(testCaseLambok));
    }

    @Test
    public void secondTest() {
        TestCaseLambokBuilder testCaseLambokBuilder = TestCaseLambokBuilder.builder()
                .title("Test title")
                //.estimate(10)
                .reference("Link 1")
                .reference("Link 2")
                .reference("Link 3")
                .build();
        String title = testCaseLambokBuilder.getTitle();

        System.out.println(title);
        System.out.println(testCaseLambokBuilder.getEstimate());
        System.out.println(testCaseLambokBuilder.toString());
        System.out.println(testCaseLambokBuilder.getReferences().size());
        System.out.println(testCaseLambokBuilder.getReferences().get(0));
        System.out.println(testCaseLambokBuilder.hashCode());
        System.out.println(testCaseLambokBuilder.equals(testCaseLambokBuilder));

    }
}
