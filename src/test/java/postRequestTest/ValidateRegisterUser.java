package postRequestTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ValidateRegisterUser {



        @Test
        public void validateRegistrationTest() throws JSONException {

            RequestSpecification request=RestAssured.given();
            request.header("Content-Type","Application/json");
            JSONObject requestJson=new JSONObject();

            try{
                requestJson.put("email","sydney@fife");
                requestJson.put("password","pistol");


            }
            catch(JSONException e){
                e.printStackTrace();
            }

request.body(requestJson.toString());
        Response response = request.post("https://reqres.in/api/register");
        response.prettyPrint();
        assertTrue(response.getStatusCode() == 201);
        System.out.println(response.getBody().asString());

    }

    @Test
    public void invalidRegistrationTest(String POST){

        RequestSpecification request=RestAssured.given();
        request.header("Content-Type","Application/json");
        JSONObject requestJson=new JSONObject();

        try{
            requestJson.put("email","akancha@fife");
            requestJson.put("password","");


        }
        catch(JSONException e){
            e.printStackTrace();
        }

        request.body(requestJson.toString());
        Response response = request.post(POST);
        response.prettyPrint();
        assertTrue(response.getStatusCode() == 400);
        System.out.println(response.getBody().asString());


    }





}
