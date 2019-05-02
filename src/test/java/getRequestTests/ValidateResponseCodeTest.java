package getRequestTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.parsing.Parser;

import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;

public class ValidateResponseCodeTest {


    @Test
    public void validateResponseCode() throws JSONException {

        Response response = RestAssured.get("https://reqres.in/api/users/1");
        assertTrue(response.getStatusCode() == 200);
        System.out.println(response.getBody().asString());
        validateData(response);
    }


    public void validateData(Response response) {

        Map<String,String> map1=new HashMap<>();
        map1.put("id","1");
        map1.put("first_name","George");
        map1.put("last_name","Bluth");
        map1.put("avatar","https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");


        Map<String, ?> actualData = response.jsonPath().getMap("data");


       String id=actualData.get("id").toString();
       System.out.println("id:" + actualData.get("id").toString());
        System.out.println("first_name:"+actualData.get("first_name").toString());
        System.out.println("last_name:"+actualData.get("last_name").toString());
        System.out.println("avatar:"+actualData.get("avatar").toString());
//for(int i=0;i<actualData.size();i++){


        Assert.assertEquals(map1.get("id").toString(),actualData.get("id").toString());
        Assert.assertEquals(map1.get("first_name").toString(),actualData.get("first_name").toString());
        Assert.assertEquals(map1.get("last_name").toString(),actualData.get("last_name").toString());
        Assert.assertEquals(map1.get("avatar").toString(),actualData.get("avatar").toString());










      /*      HashMap<String ,String > hashMap=new HashMap<String, String>();
        hashMap.put("id","1");
        hashMap.put("first_name","George");
        hashMap.put("last_name","Bluth");
        hashMap.put("avatar","https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");

        JSONObject json = new JSONObject();
        json.putAll( hashMap );
        System.out.printf( "JSON: %s", json.toString(2) );


       */



    }
}
