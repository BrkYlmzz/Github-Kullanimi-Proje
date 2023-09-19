
package test;

import baseURL.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

public class C17_BaseUrlHerOkuAppQueryParam extends HerOkuAppBaseUrl {

    /*

    @Test
    public void get01(){

        // URL hazirla

        specHerokuApp.pathParam("pp1","booking");

        // 2- Expected Data hazirla

        // 3 - Response'i kaydet

        Response response=given().
                              spec(specHerokuApp).
                          when().
                              get("/{pp1}");

        response.prettyPrint();

        // 4 - Assertion

        response.
                then().
                assertThat().
                statusCode(200).
                body("bookingid",hasItem(3119));
    }

    @Test
    public void get02(){

        specHerokuApp.pathParam("pp1","booking").queryParam("firstname","Eric");

        Response response=given().spec(specHerokuApp).when().get("/{pp1}");

        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                body("bookingid",hasSize(1));
    }

    @Test
    public void get03(){
        specHerokuApp.pathParam("pp1","booking").queryParams("firstname","Jim","lastname","Jackson");

        Response response=given().spec(specHerokuApp.when().given("/{pp1}"));

        response.prettyPrint();

        response.then().assertThat().statusCode(200).body("booking",hasSize(1));
    }

     */

}