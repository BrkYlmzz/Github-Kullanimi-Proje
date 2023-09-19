package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class C01_GetApiSorgulama {

    @Test
    public void get01(){
        String url="https://restful-booker.herokuapp.com/booking/672";
        Response response=given().when().get(url);
        response.prettyPrint();
        System.out.println("Status Code :"+response.getStatusCode());
        System.out.println("Content Type :"+response.getContentType());
        System.out.println("Server Header'inin Degeri :"+response.getHeader("Server"));
        System.out.println("Status Line :"+response.getStatusLine());
        System.out.println("Response Suresi :"+response.getTime());
    }
}
