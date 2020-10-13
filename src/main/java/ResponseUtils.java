package com.marina.utils;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.util.Arrays;
import java.util.List;



public class ResponseUtils {


    public static String getHeader(CloseableHttpResponse response, String headerName) {
        //get all headers
        Header[] headers = response.getAllHeaders();
        List<Header> httpHeaders = Arrays.asList(headers);
        String returnHeader ="";

        //loop over the headers list
        for(Header header: httpHeaders){
            if(headerName.equalsIgnoreCase(header.getName())){
                returnHeader = header.getValue();
            }
        }
        //if no header found - throw an exception
        if(returnHeader.isEmpty()){
            throw new RuntimeException("Didn't find the header" + headerName);
        }
        return returnHeader;

    }
}
