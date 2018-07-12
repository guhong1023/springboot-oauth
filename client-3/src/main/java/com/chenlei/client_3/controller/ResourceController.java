package com.chenlei.client_3.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 陈磊
 * @Date: 2018/7/11
 * @Description:
 */

@RestController
@RequestMapping("/resource")
public class ResourceController {

    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private OAuth2RestOperations oAuth2RestTemplate;

    @RequestMapping("/")
    public String getResource() {
        logger.debug("I am client-3 and I will call client-2...");
        String result = oAuth2RestTemplate.getForObject("http://localhost:8082/client-2/resource/", String.class);
        logger.debug("The client-2 say: " + result);
        return "I am client-3!!!";
    }

}