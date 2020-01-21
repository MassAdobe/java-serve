package com.massadobe.means.demo.configs;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.massadobe.means.demo.constants.ConstantsConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: ExtendCommonConfiguration
 * @Author: MassAdobe
 * @Email: massadobe8@gmail.com
 * @Description: TODO
 * @Date: Created in 2020-01-06 17:03
 * @Version: 1.0.0
 * @param: * @param null
 */
@Configuration
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = ConstantsConfig.NACOS_ADDRS))
@NacosPropertySource(dataId = ConstantsConfig.NACOS_COMMON_EXTEND_FILE_NAME, groupId = ConstantsConfig.NACOS_COMMON_EXTEND_GROUP, autoRefreshed = ConstantsConfig.NACOS_REFRESH, type = ConfigType.YAML)
public class ExtendCommonConfiguration {

    private final static Logger logger = LoggerFactory.getLogger(ExtendCommonConfiguration.class);

    private static String appId = "guang2020lian";
    private static String appSecret = "iefa*&Y^873hfcd";
    private static String appIdKey = "idjekdi873kj1ad198cid28yee21jd87";
    private static String appSecretKey = "ifjekd7309kj1ad198cid28abb21jd65";

//    private static String appId = "guang2020lian";
//    private static String appSecret = "iefa*&Y^873hfcd";
//    private static String appIdKey = "idjekdi873kj1ad198cid28yee21jd87";
//    private static String appSecretKey = "ifjekd7309kj1ad198cid28abb21jd65";
//
//    @NacosValue(value = "${app.id}", autoRefreshed = true)
//    public void setAppId(String appId) {
//        ExtendCommonConfiguration.appId = appId;
//    }
//
//    @NacosValue(value = "${app.secret}", autoRefreshed = true)
//    public void setAppSecret(String appSecret) {
//        ExtendCommonConfiguration.appSecret = appSecret;
//    }
//
//    @NacosValue(value = "${app.id-key}", autoRefreshed = true)
//    public void setAppIdKey(String appIdKey) {
//        ExtendCommonConfiguration.appIdKey = appIdKey;
//    }
//
//    @NacosValue(value = "${app.secret-key}", autoRefreshed = true)
//    public void setAppSecretKey(String appSecretKey) {
//        ExtendCommonConfiguration.appSecretKey = appSecretKey;
//    }

    public static String getAppId() {
        return appId;
    }

    public static String getAppSecret() {
        return appSecret;
    }

    public static String getAppIdKey() {
        return appIdKey;
    }

    public static String getAppSecretKey() {
        return appSecretKey;
    }
}
