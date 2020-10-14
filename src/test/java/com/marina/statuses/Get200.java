package com.marina.statuses;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.Closeable;
import java.io.IOException;

public class Get200 extends BaseClass {


    @Test
    public void baseUrlReturn200() throws IOException {
        HttpGet get = new HttpGet( BASE_ENDPOINT);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatus, 200);

    }

    @Test
    public void rateLimitReturn200() throws IOException {
        HttpGet get = new HttpGet( BASE_ENDPOINT+ "/rate_limit");
         response = client.execute(get);
         int actualStatus = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatus, 200);

    }
    @Test
    public void searchReposReturn200() throws IOException {
        HttpGet get = new HttpGet( BASE_ENDPOINT+ "/search/repositories?q=java");
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatus, 200);

    }
}
