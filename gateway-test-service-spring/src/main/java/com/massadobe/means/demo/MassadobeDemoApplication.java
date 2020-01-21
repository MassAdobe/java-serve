package com.massadobe.means.demo;

import com.massadobe.means.demo.config.OSinfo;
import com.massadobe.means.demo.constants.ConstantsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Properties;


/**
 * @ClassName: AttemptApplication
 * @Author: MassAdobe
 * @Email: massadobe8@gmail.com
 * @Description: TODO
 * @Date: Created in 2019-12-13 15:09
 * @Version: 1.0.0
 * @param: * @param null
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class MassadobeDemoApplication {
    public static void main(String[] args) {
        Properties properties = new Properties();
        if (OSinfo.isWindows()) {
            properties.setProperty(ConstantsConfig.LOG_CONFIG_LOCATION_NAME, ConstantsConfig.WIN_LOG_PATH);
        } else if (OSinfo.isMacOSX() || OSinfo.isMacOS()) {
            properties.setProperty(ConstantsConfig.LOG_CONFIG_LOCATION_NAME, ConstantsConfig.MAC_LOG_PATH);
        } else {
            properties.setProperty(ConstantsConfig.LOG_CONFIG_LOCATION_NAME, ConstantsConfig.LINUX_LOG_PATH);
        }
        SpringApplication app = new SpringApplication(MassadobeDemoApplication.class);
        app.setDefaultProperties(properties);
        app.run(args);
    }
}
