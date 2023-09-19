package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {

    /*

    https://dummy.restapiexample.com/api/v1/employee/3 URL'ine bir GET request
    gonderdiginizde donen response'un asagidaki gibi oldugunu test edin

    Response Body

    {
    "status":"succes",
    "data":{
            "id":3,
            "employee_name":"Ashtan Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Succesfully! Record has been fetched."
    }

     */

    @Test
    public void get01(){

        String url="https://dummy.restapiexample.com/api/v1/employee/3";

        JSONObject innerBody=new JSONObject();

        innerBody.put("id",3);
        innerBody.put("employee_name","Ashtan Cox");
        innerBody.put("employee_salary",8600);
        innerBody.put("employee_age",66);
        innerBody.put("profile_image","");

        JSONObject expBody=new JSONObject();

        expBody.put("status","succes");
        expBody.put("data",innerBody);
        expBody.put("message","Succesfully! Record has been fetched.");

        Response response=given().when().get(url);

        JsonPath resJPath=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(resJPath.get("status"),expBody.get("status"));
        softAssert.assertEquals(resJPath.get("data.id"),expBody.getJSONObject("data").get("id"));
        softAssert.assertEquals(resJPath.get("data.employee_name"),expBody.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(resJPath.get("data.employee_salary"),expBody.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(resJPath.get("data.employee_age"),expBody.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(resJPath.get("data.profile_image"), expBody.getJSONObject("data").get("profile_image"));
        softAssert.assertEquals(resJPath.get("message"),expBody.get("message"));

        softAssert.assertAll();
    }
}
