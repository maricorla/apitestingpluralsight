package com.marina.statuses;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void serverIsGithub() throws IOException {
        HttpGet get = new HttpGet( BASE_ENDPOINT);
        response = client.execute(get);
        String headerValue = com.marina.utils.ResponseUtils.getHeader(response, "Server");
        Assert.assertEquals(headerValue, "GitHub.com");
    }



}
