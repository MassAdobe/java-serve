package com.massadobe.means.demo.controller;

import com.massadobe.means.demo.constants.ConstantsConfig;
import com.massadobe.means.demo.pojo.ResponseStruct;
import com.massadobe.means.demo.pojo.TokenStruct;
import com.massadobe.means.demo.utils.FastDFSUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: FastDFSController
 * @Author: MassAdobe
 * @Email: massadobe8@gmail.com
 * @Description: 获取相关token的controller
 * @Date: Created in 2020-01-16 10:26
 * @Version: 1.0.0
 * @param: * @param null
 */
@RestController
@RequestMapping(value = ConstantsConfig.APPLICATION_NAME + "/fastDfs")
public class FastDFSController extends BasicContoller {

    private final static Logger logger = LoggerFactory.getLogger(FastDFSController.class);

    /**
     * @ClassName: FastDFSController
     * @Author: MassAdobe
     * @Email: massadobe8@gmail.com
     * @Description: 获取Token
     * @Date: Created in 2020-01-16 15:56
     * @Version: 1.0.0
     * @param: * @param null
     */
    @GetMapping("/getToken")
    public ResponseStruct getToken() {
        String token = FastDFSUtils.getToken();
        return ResponseStruct.success(new TokenStruct(token));
    }

}
