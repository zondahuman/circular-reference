package com.abin.lee.circular.main.controller;

import com.abin.lee.circular.common.util.JsonUtil;
import com.abin.lee.circular.main.vo.request.UserVo;
import com.abin.lee.circular.main.vo.response.BaseVo;
import com.abin.lee.circular.service.SlapService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    public BaseVo call(String id, HttpServletRequest request) {
        LOGGER.info("id={}", id);
        String response = "FAILURE";
        String headers = request.getHeader("STATUS_INPUT");
        LOGGER.info("id={} headers={}", id, headers);
        try {
            this.slapService.callSlap(id);
            LOGGER.info("response={}", response);
            response = "SUCCESS";
        } catch (Exception e) {
            LOGGER.error("e={}", e);
            return BaseVo.error();
        }
        return BaseVo.success();
    }


//    @RequestMapping(value = "/user", method= RequestMethod.POST, headers="Accept=application/json")
    @RequestMapping(value = "/user", method= RequestMethod.POST)
    @ResponseBody
    public BaseVo user(@RequestBody UserVo userVo, HttpServletRequest request) {
        LOGGER.info("userVo={}", JsonUtil.toJson(userVo));
        String response = "FAILURE";
        String headers = request.getHeader("STATUS_INPUT");
        LOGGER.info("userVo={} headers={}", JsonUtil.toJson(userVo), headers);
        try {
            this.slapService.callSlap(String.valueOf(userVo.getId()));
            LOGGER.info("response={}", response);
        } catch (Exception e) {
            LOGGER.error("e={}", e);
            return BaseVo.error();
        }
        return BaseVo.success();
    }


}
