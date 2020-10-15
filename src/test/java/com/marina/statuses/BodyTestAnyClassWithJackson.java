package com.marina.statuses;

import com.marina.utils.NotFound;
import com.marina.utils.User;
import org.apache.http.client.methods.HttpGet;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.marina.utils.ResponseUtils.unmarshall;
import static com.marina.utils.ResponseUtils.unmarshallGeneric;

public class BodyTestAnyClassWithJackson extends BaseClass {
    @Test
    public void returnCorrectLogin() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/maricorla");
        response = client.execute(get);

        User user =  unmarshallGeneric(response, User.class);
        Assert.assertEquals(user.getLogin(), "maricorla");
    }

    @Test
    public void returnCorrectId() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/maricorla");
        response = client.execute(get);

        User user =  unmarshallGeneric(response, User.class);
        Assert.assertEquals(user.getId(), 55948662);
    }
    @Test(enabled = true)
    public void NotFoundMessageIsCorrect() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/nonexistingendpoint");
        response = client.execute(get);

        NotFound notFoundMessage =  unmarshallGeneric(response, NotFound.class);
        Assert.assertEquals(notFoundMessage.getMessage(), "Not Found");
    }


}

