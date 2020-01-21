package com.massadobe.means.demo.utils;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.massadobe.means.demo.configs.ExtendCommonConfiguration;
import com.massadobe.means.demo.constants.HttpConstant;
import com.massadobe.means.demo.controller.FastDFSController;
import okhttp3.Headers;
import org.springframework.stereotype.Component;

/**
 * @ClassName: FastDFSUtils
 * @Author: MassAdobe
 * @Email: massadobe8@gmail.com
 * @Description: 分布式文件存储系统的工具类
 * @Date: Created in 2020-01-16 15:53
 * @Version: 1.0.0
 * @param: * @param null
 */
@Component
public class FastDFSUtils {

    //    private static String url;
    private static String url = "http://127.0.0.1:10061/fdfs-token/token/getToken";

//    @NacosValue(value = "${app.url}", autoRefreshed = true)
//    public void setUrl(String url) {
//        FastDFSUtils.url = url;
//    }

    /**
     * @ClassName: FastDFSUtils
     * @Author: MassAdobe
     * @Email: massadobe8@gmail.com
     * @Description: 发送至FastDFS服务获取token
     * @Date: Created in 2020-01-16 17:05
     * @Version: 1.0.0
     * @param: * @param null
     */
    public static String getToken() {
        String ans = OkHttpUtil.postJsonParams(url, "", new Headers.Builder().add(HttpConstant.CONTENT_TYPE, HttpConstant.CONTENT_TYPE_INNER)
                .add(HttpConstant.APP_ID_KEY, Base64Util.encrypt(ExtendCommonConfiguration.getAppId(), ExtendCommonConfiguration.getAppIdKey()))
                .add(HttpConstant.APP_SECRET_KEY, Base64Util.encrypt(ExtendCommonConfiguration.getAppSecret(), ExtendCommonConfiguration.getAppSecretKey())).build());
        return ans;
    }

}
