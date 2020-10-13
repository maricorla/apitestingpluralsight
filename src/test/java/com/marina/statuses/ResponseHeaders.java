package com.marina.statuses;

import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ResponseHeaders extends BaseClass {
    @Test
    public void contentTypeIsJson() throws IOException {
        HttpGet get = new HttpGet( BASE_ENDPOINT);
        response = client.execute(get);

         Header contentType = response.getEntity().getContentType();
        Assert.assertEquals(contentType.getValue(), "application/json; charset=utf-8");

        //if you want test only first part application/json
        ContentType ct = ContentType.getOrDefault(response.getEntity());
        Assert.assertEquals(ct.getMimeType(), "application/json");
    }

}
