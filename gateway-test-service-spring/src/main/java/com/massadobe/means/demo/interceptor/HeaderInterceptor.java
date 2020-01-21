package com.massadobe.means.demo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("all")
public class HeaderInterceptor extends HandlerInterceptorAdapter {

    private final static Logger logger = LoggerFactory.getLogger(HeaderInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        setRequestUser(null);
//        if (Strings.isNullOrEmpty(request.getHeader(ConstantsConfig.USER_INFO))) {
//        } else {
//            ObjectMapper objectMapper = new ObjectMapper();
//            try {
//                setRequestUser(objectMapper.readValue(request.getHeader(ConstantsConfig.USER_INFO), RequestUser.class));
//                logger.info(Strings.lenientFormat("---------------%s---------------", request.getHeader(ConstantsConfig.USER_INFO)));
//            } catch (IOException e) {
//                logger.error(Strings.lenientFormat("【ASPECT-SESSION-BEFORE】：ERROR：{%s}", e.getMessage()));
//                throw new AttemptException(ErrorCodeMsg.JSON_DECODE_ERROR);
//            }
//        }
        System.out.println("preHandle 方法。。。");
        return super.preHandle(request, response, handler);
    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle 方法。。。");
//        super.postHandle(request, response, handler, modelAndView);
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
//                                Exception ex) throws Exception {
//        System.out.println("afterCompletion 方法。。。");
//        super.afterCompletion(request, response, handler, ex);
//    }
//
//    @Override
//    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response,
//                                               Object handler) throws Exception {
//        System.out.println("afterConcurrentHandlingStarted 方法。。。");
//        super.afterConcurrentHandlingStarted(request, response, handler);
//    }

}
