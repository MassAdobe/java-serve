package com.massadobe.means.demo.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.google.common.base.Strings;
import com.massadobe.means.demo.constants.ConstantsConfig;
import com.massadobe.means.demo.enums.ErrorCodeMsg;
import com.massadobe.means.demo.exception.AttemptException;
import com.massadobe.means.demo.exception.ExceptionUtils;
import com.massadobe.means.demo.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: Hello
 * @Author: MassAdobe
 * @Email: massadobe8@gmail.com
 * @Description: TODO
 * @Date: Created in 2019-12-13 14:50
 * @Version: 1.0.0
 * @param: * @param null
 */
@RestController
@RequestMapping(value = ConstantsConfig.APPLICATION_NAME + "/hello")
public class Hello extends BasicContoller {

    private final static Logger logger = LoggerFactory.getLogger(Hello.class);

    @NacosValue(value = "${testing.testinga}", autoRefreshed = true)
    private String TestingValue;


    @GetMapping("/printSth")
    public ResponseStruct PrintSth(@ModelAttribute RequestUser requestUser) {
        String ans = Strings.lenientFormat("guid: %s, sysid: %s", requestUser.getGuid(), requestUser.getSysid());
        return ResponseStruct.success(ans);
    }

    @GetMapping("/returnError")
    public ResponseStruct ReturnError() {
        return ExceptionUtils.ReturnError(ErrorCodeMsg.RETURN_ERROR_EXAMPLE, "abc", "efg");
    }

    @GetMapping("/otherError")
    public ResponseStruct OtherError() throws Exception {
        System.out.println("abc");
        System.out.println("efg");
        throw new Exception("直接抛出异常");
    }

    @GetMapping("/checkError")
    public ResponseStruct checkError() {
        System.out.println("进入");
        throw new AttemptException(ErrorCodeMsg.HEADER_USER_ERROR, "abc");
    }

    /**
     * @ClassName: Hello
     * @Author: MassAdobe
     * @Email: massadobe8@gmail.com
     * @Description: get请求没有参数
     * @Date: Created in 2020-01-14 20:49
     * @Version: 1.0.0
     * @param: * @param null
     */
    @GetMapping("/testGetWithoutParams")
    public ResponseStruct testGetWithoutParams(@ModelAttribute RequestUser requestUser) {
        return ResponseStruct.success(new GetWithoutParams(requestUser.getGuid(), requestUser.getSysid(), "testGetWithoutParams"));
    }

    /**
     * @ClassName: Hello
     * @Author: MassAdobe
     * @Email: massadobe8@gmail.com
     * @Description: get请求有参数
     * @Date: Created in 2020-01-14 20:49
     * @Version: 1.0.0
     * @param: * @param null
     */
    @GetMapping("/testGetWithParams")
    public ResponseStruct testGetWithParams(@RequestParam String name, @RequestParam Integer age, @RequestParam Long personId, @ModelAttribute RequestUser requestUser) {
        return ResponseStruct.success(new GetWithParams(name, age, personId, requestUser.getGuid(), requestUser.getSysid()));
    }

    /**
     * @ClassName: Hello
     * @Author: MassAdobe
     * @Email: massadobe8@gmail.com
     * @Description: post请求没有参数
     * @Date: Created in 2020-01-14 20:58
     * @Version: 1.0.0
     * @param: * @param null
     */
    @PostMapping("/testPostWithoutParams")
    public ResponseStruct testPostWithoutParams(@ModelAttribute RequestUser requestUser) {
        return ResponseStruct.success(new GetWithoutParams(requestUser.getGuid(), requestUser.getSysid(), "testPostWithoutParams"));
    }

    /**
     * @ClassName: Hello
     * @Author: MassAdobe
     * @Email: massadobe8@gmail.com
     * @Description: post请求有参数
     * @Date: Created in 2020-01-14 20:58
     * @Version: 1.0.0
     * @param: * @param null
     */
    @PostMapping("/testPostWithParams")
    public ResponseStruct testPostWithParams(@RequestBody GetWithParams getWithParams, @ModelAttribute RequestUser requestUser) {
        return ResponseStruct.success(new GetWithParams(getWithParams.getName(), getWithParams.getAge(), getWithParams.getPersonId(), requestUser.getGuid(), requestUser.getSysid()));
    }

    /**
     * @ClassName: Hello
     * @Author: MassAdobe
     * @Email: massadobe8@gmail.com
     * @Description: post请求复杂参数
     * @Date: Created in 2020-01-14 21:01
     * @Version: 1.0.0
     * @param: * @param null
     */
    @PostMapping("/testPostComplexRequest")
    public ResponseStruct testPostComplexRequest(@RequestBody PrintEveryth printEveryth, @ModelAttribute RequestUser requestUser) {
        System.out.println(requestUser.getSysid());
        System.out.println(requestUser.getGuid());
        return ResponseStruct.success(printEveryth);
    }

    /**
     * @ClassName: Hello
     * @Author: MassAdobe
     * @Email: massadobe8@gmail.com
     * @Description: get请求不需要过滤接口
     * @Date: Created in 2020-01-14 21:01
     * @Version: 1.0.0
     * @param: * @param null
     */
    @GetMapping("/getWithoutFilter")
    public ResponseStruct getWithoutFilter(@RequestParam String name, @RequestParam Integer age, @RequestParam Long personId, HttpServletResponse response) {
        GetWithParams getWithParams = new GetWithParams(name, age, personId);
        response.addHeader(ConstantsConfig.USER_ID, "1");
        return ResponseStruct.success(getWithParams);
    }

    /**
     * @ClassName: Hello
     * @Author: MassAdobe
     * @Email: massadobe8@gmail.com
     * @Description: post请求不需要过滤接口
     * @Date: Created in 2020-01-14 21:04
     * @Version: 1.0.0
     * @param: * @param null
     */
    @PostMapping("/postWithoutFilter")
    public ResponseStruct postWithoutFilter(@RequestBody GetWithParams getWithParams, HttpServletResponse response) {
        response.addHeader(ConstantsConfig.USER_ID, "1");
        return ResponseStruct.success(getWithParams);
    }

    public String getTestingValue(@ModelAttribute RequestUser requestUser) {
        return TestingValue;
    }

    public void setTestingValue(String testingValue) {
        TestingValue = testingValue;
    }
}
