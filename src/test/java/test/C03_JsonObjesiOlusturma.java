package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma {

    @Test
    public void jsonObje01(){

        JSONObject ilkJsonObje=new JSONObject();

        ilkJsonObje.put("title","Ahmet");
        ilkJsonObje.put("body","Merhaba");
        ilkJsonObje.put("userId",1);

        System.out.println(ilkJsonObje);
    }

    @Test
    public void jsonObje02(){

        JSONObject innerJsonObje=new JSONObject();
        innerJsonObje.put("checkin","2018-01-01");
        innerJsonObje.put("checkout","2019-01-01");

        JSONObject body=new JSONObject();

        body.put("fistname","Jİm");
        body.put("additionalneeds","Breakfast");
        body.put("bookingdates",innerJsonObje);
        body.put("totalprice",111);
        body.put("depositpaid",true);
        body.put("lastname","Brown");

        System.out.println(body);

    }
}
