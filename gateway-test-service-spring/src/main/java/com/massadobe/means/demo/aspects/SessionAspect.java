package com.massadobe.means.demo.aspects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.massadobe.means.demo.constants.ConstantsConfig;
import com.massadobe.means.demo.constants.HttpConstant;
import com.massadobe.means.demo.controller.Hello;
import com.massadobe.means.demo.enums.ErrorCodeMsg;
import com.massadobe.means.demo.exception.AttemptException;
import com.massadobe.means.demo.pojo.RequestUser;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: SessionAspect
 * @Author: MassAdobe
 * @Email: massadobe8@gmail.com
 * @Description: TODO
 * @Date: Created in 2019-12-13 14:15
 * @Version: 1.0.0
 * @param: * @param null
 */
@Aspect
@Component
public class SessionAspect {
    private final static Logger logger = LoggerFactory.getLogger(SessionAspect.class);

    private static final String SESSION_POINT_CUT = "execution(* com.massadobe.means.demo.controller.*.*(..))";

    @Pointcut(SESSION_POINT_CUT)
    public void Session() {

    }

//    @Before("Session()")
//    public void SessionBefore() {
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = servletRequestAttributes.getRequest();
//        if (!Strings.isNullOrEmpty(request.getHeader(ConstantsConfig.DELTATIME))) {
//            deltaTime = request.getHeader(ConstantsConfig.DELTATIME);
//        }
//        try {
//            BufferedReader br = request.getReader();
//            String str, wholeStr = "";
//            while ((str = br.readLine()) != null) {
//                wholeStr += str;
//            }
//            System.out.println(wholeStr);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (!Strings.isNullOrEmpty(request.getHeader(ConstantsConfig.USER_INFO))) {
//            ObjectMapper objectMapper = new ObjectMapper();
//            try {
//                Hello.setRequestUser(objectMapper.readValue(request.getHeader(ConstantsConfig.USER_INFO), RequestUser.class));
//                logger.info(Strings.lenientFormat("---------------%s---------------", request.getHeader(ConstantsConfig.USER_INFO)));
//            } catch (IOException e) {
//                logger.error(Strings.lenientFormat("【ASPECT-SESSION-BEFORE】：ERROR：{%s}", e.getMessage()));
//                throw new AttemptException(ErrorCodeMsg.JSON_DECODE_ERROR);
//            }
//        }
//    }

    @After("Session()")
    public void SessionAfter() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
//        if (!Strings.isNullOrEmpty(deltaTime)) {
//            response.setHeader(ConstantsConfig.DELTATIME, deltaTime);
//        }
        response.setHeader(HttpConstant.CONTENT_TYPE, HttpConstant.CONTENT_TYPE_INNER);
    }

//    @AfterReturning(value = SESSION_POINT_CUT, returning = "keys")
//    public void SessionReturning(JoinPoint joinPoint, Object keys) {
//        if (keys instanceof ResponseStruct) {
//            ResponseStruct responseStruct = (ResponseStruct) keys;
//            responseStruct.setPermission("this is for test");
//        }
//    }
}
