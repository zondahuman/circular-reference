package com.abin.lee.circular.main.test;

import com.abin.lee.circular.common.util.RestTemplateUtil;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by abin on 2017/4/24 19:21.
 * circular-reference
 * com.abin.lee.circular.main.test
 */
public class CircularExecuteTest {
    private static String httpUrl = "http://localhost:8300/circular/call";


    public static void main(String[] args) {
        Map<String, String> request = Maps.newHashMap();
        request.put("id", "1");
        Map<String, String> headers = Maps.newHashMap();
        request.put("STATUS_INPUT", "HAHA");
        String result = RestTemplateUtil.getInstance().httpPost(httpUrl,request, headers);
        System.out.println("result="+result);
    }

    @Test
    public void testCircularExecute1(){
        Map<String, String> request = Maps.newHashMap();
        request.put("id", "1");
        Map<String, String> headers = Maps.newHashMap();
        headers.put("STATUS_INPUT", "HAHA");
        String result = RestTemplateUtil.getInstance().httpPost(httpUrl,request, headers);
        System.out.println("result="+result);
    }


    @Test
    public void testCircularExecute2(){
        Map<String, String> request = Maps.newHashMap();
        request.put("id", "1");
        String result = RestTemplateUtil.getInstance().httpPost(httpUrl,request);
        System.out.println("result="+result);
    }

    @Test
    public void testCircularExecute3(){
        String result = RestTemplateUtil.getInstance().httpGetById(httpUrl, "1");
        System.out.println("result="+result);
    }
}
