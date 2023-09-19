package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class C09_Post_JsonPathIleBodyTesti {

    @Test
    public void post01(){

        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject reqbody=new JSONObject();
        JSONObject innerJsonObje=new JSONObject();

        innerJsonObje.put("checkin","2021-06-01");
        innerJsonObje.put("checkout","2021-06-10");

        reqbody.put("firstname","Ali");
        reqbody.put("lastname","Bak");
        reqbody.put("totalprice",500);
        reqbody.put("depositpaid",false);
        reqbody.put("bookingdates",innerJsonObje);
        reqbody.put("additionalneeds","wi-fi");

        Response response=given().
                contentType(ContentType.JSON).
                when().
                body(reqbody.toString()).post(url);
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("booking.firstname",equalTo("Ali"),
                "booking.lastname",equalTo("Bak"),
                "booking.totalprice",equalTo(500),
                "booking.depositpaid",equalTo(false),
                "booking.bookingdates.checkin",equalTo("2021-06-01"),
                "booking.bookingdates.checkout",equalTo("2021-06-10"),
                "booking.additionalneeds",equalTo("wi-fi"));
    }
}
