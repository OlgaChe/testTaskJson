package testTaskOne;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;


/**
 * Created by olga on 8/1/2018.
 */
public class testTaskOne {

    //Positive test
    @Test
    public void testPass () {
        //Check that request status code is 200
        when().request("GET", "https://api.github.com/users/6wl").then().statusCode(200);

        //Check that the correct user login is returned
        get("https://api.github.com/users/6wl").then().assertThat().body("login", equalTo("6wl"));


        //Check the following
        //      - name = Gregory Loscombe
        //      - id = 15330
        //      - company = Amplience
        //      - location = London
        //      - public repos = 5
        //      - public gists = 10
        //      - followers = 10 //updated to 11
        //      - following = 26

        get("https://api.github.com/users/6wl").then().assertThat().body("name", equalTo("Gregory Loscombe"));
        get("https://api.github.com/users/6wl").then().assertThat().body("id", equalTo(15330));
        get("https://api.github.com/users/6wl").then().assertThat().body("company", equalTo("Amplience"));
        get("https://api.github.com/users/6wl").then().assertThat().body("location", equalTo("London"));
        get("https://api.github.com/users/6wl").then().assertThat().body("public_repos", equalTo(5));
        get("https://api.github.com/users/6wl").then().assertThat().body("public_gists", equalTo(10));
        get("https://api.github.com/users/6wl").then().assertThat().body("followers", equalTo(11)); //Data changed
        get("https://api.github.com/users/6wl").then().assertThat().body("following", equalTo(26));

    }

    //Negative test
    @Test
    public void testFail () {

        //Check that asser error shown if data is invalid

        get("https://api.github.com/users/6wl").then().assertThat().body("location", equalTo("New York"));

    }
}
