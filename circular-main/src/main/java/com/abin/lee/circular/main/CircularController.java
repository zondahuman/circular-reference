package com.abin.lee.circular.main;

import com.abin.lee.circular.service.SlapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by abin on 2017/4/24 13:12.
 * circular-reference
 * com.abin.lee.circular.main
 */
@Controller
@RequestMapping("/circular")
public class CircularController {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Resource
    SlapService slapService;

    @RequestMapping(value = "/call")
    @ResponseBody
    public String call(String id) {
        LOGGER.info("id={}", id);
        String response = "FAILURE";
        try {
            this.slapService.callSlap(id);
            LOGGER.info("response={}", response);
            response = "SUCCESS";
        } catch (Exception e) {
            LOGGER.error("e={}", e);
            response = "FAILURE";
        }
        return response;
    }


}
