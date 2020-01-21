package com.massadobe.means.demo.configs;

import com.google.common.base.Strings;
import com.massadobe.means.demo.enums.ErrorCodeMsg;
import com.massadobe.means.demo.exception.AttemptException;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: OkHttpConfig
 * @Author: MassAdobe
 * @Email: massadobe8@gmail.com
 * @Description: okHttp配置
 * @Date: Created in 2020-01-16 16:07
 * @Version: 1.0.0
 * @param: * @param null
 */
@Configuration
public class OkHttpConfig {

    private final static Logger logger = LoggerFactory.getLogger(ExtendCommonConfiguration.class);

    @Bean
    public X509TrustManager x509TrustManager() {
        return new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
    }

    @Bean
    public SSLSocketFactory sslSocketFactory() {
        try {
            //信任任何链接
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{x509TrustManager()}, new SecureRandom());
            return sslContext.getSocketFactory();
        } catch (NoSuchAlgorithmException e) {
            logger.error(Strings.lenientFormat("【OK-HTTP-CONFIG】：%s", ErrorCodeMsg.OK_HTTP_ERROR));
            throw new AttemptException(ErrorCodeMsg.SERVER_ERROR);
        } catch (KeyManagementException e) {
            logger.error(Strings.lenientFormat("【OK-HTTP-CONFIG】：%s", ErrorCodeMsg.OK_HTTP_ERROR));
            throw new AttemptException(ErrorCodeMsg.SERVER_ERROR);
        }
    }

    @Bean
    public ConnectionPool pool() {
        return new ConnectionPool(20, 3, TimeUnit.MINUTES);
    }

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .sslSocketFactory(sslSocketFactory(), x509TrustManager())
                .retryOnConnectionFailure(false)//是否开启缓存
                .connectionPool(pool())//连接池
                .connectTimeout(10L, TimeUnit.SECONDS)
                .readTimeout(10L, TimeUnit.SECONDS)
                .build();
    }

}
