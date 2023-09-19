package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

public class C10_Get_ResponseBodyTestiListKullanimi {

    @Test
    public void get01(){

        String url="https://dummy.restapiexample.com/api/v1/employees";
        Response response=given().when().get(url);

        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("data.id",hasSize(24),
                        "data.employee_name",hasItem("Ashton Cox"),
                "data.employee_age",hasItems(61,40,30));
    }
}
