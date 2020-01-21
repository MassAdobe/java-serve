package com.massadobe.means.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.massadobe.means.demo.constants.ConstantsConfig;
import com.massadobe.means.demo.enums.ErrorCodeMsg;
import com.massadobe.means.demo.exception.AttemptException;
import com.massadobe.means.demo.pojo.RequestUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
@RestController
public class BasicContoller {

    private final static Logger logger = LoggerFactory.getLogger(BasicContoller.class);

    @ModelAttribute
    public RequestUser gainSysInfo(HttpServletRequest request, HttpServletResponse response) {
        List<String> paths = new ArrayList<>();
        paths.add("/gateway-test-service/hello/getWithoutFilter");
        paths.add("/gateway-test-service/hello/postWithoutFilter");
        if (paths.contains(request.getRequestURI())) {
            return null;
        }
        RequestUser requestUser = new RequestUser();
        if (Strings.isNullOrEmpty(request.getHeader(ConstantsConfig.USER_INFO))) {
            logger.error(Strings.lenientFormat("【BASIC-CONTROLLER-GAIN-SYSTEM-INFO】：ERROR：{%s}", ErrorCodeMsg.HEADER_USER_ERROR.getMessage()));
            throw new AttemptException(ErrorCodeMsg.HEADER_USER_ERROR);
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                requestUser = (objectMapper.readValue(request.getHeader(ConstantsConfig.USER_INFO), RequestUser.class));
                if (null == requestUser.getSysid() || null == requestUser.getGuid()) {
                    logger.error(Strings.lenientFormat("【BASIC-CONTROLLER-GAIN-SYSTEM-INFO】：ERROR：{%s}", ErrorCodeMsg.HEADER_USER_ERROR.getMessage()));
                    throw new AttemptException(ErrorCodeMsg.HEADER_USER_ERROR);
                }
            } catch (IOException e) {
                logger.error(Strings.lenientFormat("【BASIC-CONTROLLER-GAIN-SYSTEM-INFO】：ERROR：{%s}", e.getMessage()));
                throw new AttemptException(ErrorCodeMsg.JSON_DECODE_ERROR);
            }
        }
        if (!Strings.isNullOrEmpty(request.getHeader(ConstantsConfig.FRONT_RENDER)))
            response.addHeader(ConstantsConfig.USER_ID, String.valueOf(requestUser.getGuid()));
        return requestUser;
    }

}
