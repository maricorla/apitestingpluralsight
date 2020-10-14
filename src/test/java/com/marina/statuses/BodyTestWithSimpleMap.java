package com.marina.statuses;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;

import static com.marina.utils.User.*;

public class BodyTestWithSimpleMap extends BaseClass {
    @Test
    public void returnFollowers() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/maricorla");
        response = client.execute(get);
//json get method works when the structure is line simple.
// If there is nest(один в другом ) то этот вид не подходит
        
        String jsonBody = EntityUtils.toString(response.getEntity());
       JSONObject jsonObject = new JSONObject(jsonBody);

       Integer actualNumFollowers = (Integer) getValueFor(jsonObject,FOLLOWERS);
        Assert.assertEquals(actualNumFollowers,Integer.valueOf(1));

    }
    @Test
    public void returnLogin() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/maricorla");
        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());
        JSONObject jsonObject = new JSONObject(jsonBody);

        String  actualLogin = (String) getValueFor(jsonObject,LOGIN);
        Assert.assertEquals(actualLogin,"maricorla");

    }

    @Test
    public void checkID() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/maricorla");
        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());
        JSONObject jsonObject = new JSONObject(jsonBody);

        Integer actualIDIs = (Integer) getValueFor(jsonObject,ID);
        Assert.assertEquals(actualIDIs,Integer.valueOf(55948662));

    }


}
