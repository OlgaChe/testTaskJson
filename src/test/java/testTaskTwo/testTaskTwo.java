package testTaskTwo;

import Pages.TestPage;
import com.sun.org.apache.xpath.internal.operations.String;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by olga on 8/1/2018.
 */
public class testTaskTwo extends MainTest {

    public TestPage testPage;

    //Check the following
    //      - name = Gregory Loscombe
    //      - id = 15330
    //      - company = Amplience
    //      - location = London
    //      - public repos = 5
    //      - public gists = 10
    //      - followers = 10 //updated to 11
    //      - following = 26

    @Test
    public void testTaskTwo(){
        driver.navigate().to("https://api.github.com/users/6wl");

        testPage = new TestPage();

        System.out.println(testPage.jsonFile.getText());
        Assert.assertTrue(testPage.jsonFile.getText().contains("\"name\": \"Gregory Loscombe\""));
        Assert.assertTrue(testPage.jsonFile.getText().contains("\"id\": 15330"));
        Assert.assertTrue(testPage.jsonFile.getText().contains("\"company\": \"Amplience\""));
        Assert.assertTrue(testPage.jsonFile.getText().contains("\"location\": \"London\""));
        Assert.assertTrue(testPage.jsonFile.getText().contains("\"public_repos\": 5"));
        Assert.assertTrue(testPage.jsonFile.getText().contains("\"public_gists\": 10"));
        Assert.assertTrue(testPage.jsonFile.getText().contains("\"followers\": 11"));
        Assert.assertTrue(testPage.jsonFile.getText().contains("\"following\": 26"));
    }
}
