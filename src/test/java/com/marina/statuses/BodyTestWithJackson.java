package com.marina.statuses;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marina.utils.User;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class BodyTestWithJackson extends BaseClass {


    @Test
    public void returnCorrectLogin() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/maricorla");
        response = client.execute(get);

       User user =  unmarshall (response, User.class);
        Assert.assertEquals(user.getLogin(), "maricorla");
    }

    private User unmarshall(CloseableHttpResponse response, Class<User> clazz) throws IOException {

        String jsonBody = EntityUtils.toString(response.getEntity());
        return new ObjectMapper()
               .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
                .readValue(jsonBody, clazz);
    }
}
