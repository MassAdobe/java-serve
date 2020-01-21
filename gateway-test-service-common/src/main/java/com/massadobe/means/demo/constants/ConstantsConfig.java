package com.massadobe.means.demo.constants;

/**
 * @ClassName: ConstantsConfig
 * @Author: MassAdobe
 * @Email: massadobe8@gmail.com
 * @Description: TODO
 * @Date: Created in 2019-12-13 12:04
 * @Version: 1.0.0
 * @param: * @param null
 */
public class ConstantsConfig {

    /**
     * log的配置名称
     */
    public final static String LOG_CONFIG_LOCATION_NAME = "logging.fileLocation";
    /**
     * windows系统log日志存放地址
     */
    public final static String WIN_LOG_PATH = "C:\\usr\\local\\data\\logs";
    /**
     * mac系统log日志存放地址
     */
    public final static String MAC_LOG_PATH = "/usr/local/data/logs";
    /**
     * linux系统log日志存放地址
     */
    public final static String LINUX_LOG_PATH = "/data/logs";
    /**
     * 网关设置deltaTime
     */
    public final static String DELTATIME = "deltatime";
    /**
     * USER信息
     */
    public final static String USER_INFO = "user";
    /**
     * nacos.config地址
     */
//    public final static String NACOS_ADDRS = "nacos1.guangl.io:8848,nacos2.guangl.io:8848,nacos3.guangl.io:8848";
    public final static String NACOS_ADDRS = "127.0.0.1:8848";
    /**
     * nacos.config.group
     */
    public final static String NACOS_GROUP = "massadobe";
    /**
     * nacos.config配置名
     */
    public final static String NACOS_FILE_NAME = "gateway-test-service.yml";
    /**
     * nacos.config.extend配置名
     */
    public final static String NACOS_EXTEND_FILE_NAME = "gateway-test-service-extend.yml";
    /**
     * common中extend的配置名
     */
    public final static String NACOS_COMMON_EXTEND_FILE_NAME = "train-common-mng-extend.yml";
    /**
     * common中extend的配置的group
     */
    public final static String NACOS_COMMON_EXTEND_GROUP = "train-common-mng";
    /**
     * 本例特殊，需要手工填入Common的NameSpace
     */
    public final static String NACOS_COMMON_EXTEND_NAMESPACE = "a3ea308e-a1aa-4180-8baa-3cfdc6c9d8c3";
    /**
     * nacos.config热更新
     */
    public final static boolean NACOS_REFRESH = true;
    /**
     * 服务名，在MVC声明时使用
     */
    public final static String APPLICATION_NAME = "/gateway-test-service";
    /**
     * 前端返回需要相关用户相关页面的渲染权限
     */
    public final static String FRONT_RENDER = "Web-Path";
    /**
     * USER信息
     */
    public final static String USER_ID = "uid";
}
