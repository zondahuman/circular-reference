package com.abin.lee.circular.main.test;

import com.abin.lee.circular.common.util.JsonUtil;
import com.abin.lee.circular.common.util.RestTemplateUtil;
import com.abin.lee.circular.main.vo.request.UserVo;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * Created by abin on 2017/4/25 2017/4/25.
 * circular-reference
 * com.abin.lee.circular.main.test
 */
public class UserTest {
//    private static String httpUrl = "http://localhost:8300/circular/user";
    private static String httpUrl = "http://localhost:7100/circular/user";


    @Test
    public void testUser1(){
        UserVo userVo = new UserVo();
        userVo.setUserName("abin");
        userVo.setAge(55);
        userVo.setId(1);
        String json = JsonUtil.toJson(userVo);
        Map<String, String> headers = Maps.newHashMap();
        headers.put("STATUS_INPUT", "what");
        String result = RestTemplateUtil.getInstance().httpPost(httpUrl,json, headers);
        System.out.println("result="+result);
    }


}
