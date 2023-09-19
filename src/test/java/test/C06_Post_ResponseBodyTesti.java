package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import java.lang.module.ResolutionException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class C06_Post_ResponseBodyTesti {

    @Test
    public void post01() {
        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody = new JSONObject();

        {
        reqBody.put("title", "API");
        reqBody.put("body", "API ogrenmek ne guzel");
        reqBody.put("userId", 10);
        }
        System.out.println(reqBody);

        Response response=given().
                contentType(ContentType.JSON).
                when().
                body(reqBody.toString()).post(url);
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(201).
                contentType("application/json").
                body("title", Matchers.equalTo("API")).
                body("userId", lessThan(100)).
                body("body",Matchers.containsString("API"));

    }

    @Test
    public void post02() {
        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody = new JSONObject();

        {
            reqBody.put("title", "API");
            reqBody.put("body", "API ogrenmek ne guzel");
            reqBody.put("userId", 10);
        }
        System.out.println(reqBody);

        Response response=given().
                contentType(ContentType.JSON).
                when().
                body(reqBody.toString()).post(url);
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(201).
                contentType("application/json").
                body("title",equalTo("API"),
                "userId",lessThan(100),
                "body",containsString("API"));
    }
}
