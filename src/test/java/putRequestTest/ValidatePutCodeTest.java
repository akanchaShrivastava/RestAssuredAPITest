package putRequestTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ValidatePutCodeTest {


    @Test
    public void putRequest() {
        Response response = RestAssured.get("https://reqres.in//api/users/2");



    }
}
