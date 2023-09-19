package test;

import baseURL.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class C15_BaseUrlJsonPlaceHolder extends JsonPlaceHolderBaseUrl {

    // Class icinde 3 Test methodu olusturun ve asagidaki testleri yapin

    public void get01(){

        /*
    1 - https://jsonplaceholder.typicode.com/posts endpoint'ine bir GET
         request gonderdiginizde donen response'un status code'unun 200 oldugunu
         ve response'ta 100 kayit oldugunu test edin
     */

        // URL hazirla

        specJsonPlace.param("pp1","posts");

        // 2 - Expected Data hazirla
        // 3 - Response'u kaydet

        Response response=
                given().
                        spec(specJsonPlace).
                when().
                        get("/{pp1}");

        // 4 - Assertion

        response.
                then().
                assertThat().
                statusCode(200).
                body("title",hasSize(100));

    }

    public void get02(){

        /*
    2 - https://jsonplaceholder.typicode.com/posts/44 endpoint'ine bir GET
         request gonderdiginizde donen response'un status code'unun 200 oldugunu
         ve "title" degerinin "optio dolor molestias sit" oldugunu test edin
     */

        // 1 - URL hazirla

        specJsonPlace.pathParams("pp1","posts","pp2",44);

        // Expected Data hazirla

        // Response'u kaydet

        Response response=given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");

        // 4 - Assertion

        response.
                then().
                assertThat().
                statusCode(200).
                body("title", equalTo("optio dolor molestias sit"));
    }

    public void get03(){

        /*
    3 - https://jsonplaceholder.typicode.com/posts/50 endpoint'ine bir DELETE
         request gonderdiginizde donen response'un status code'unun 200 oldugunu
         ve response body'sinin null oldugunu test edin
     */
    }
}
