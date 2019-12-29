package com.wochanye.demo.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

/**
 * 统一Rest请求，封装okHttp3调用
 *
 * @author cuijie
 * @since 2018-07-24
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(OkHttp3ClientHttpRequestFactory factory) {
        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

    @Bean
    public OkHttp3ClientHttpRequestFactory okHttp3ClientHttpRequestFactory() {
        return new OkHttp3ClientHttpRequestFactory(okHttpClient());
    }

    /**
     * 配置okHttp相关
     *
     * @return
     */
    @Bean
    public OkHttpClient okHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .sslSocketFactory(getTrustedSSLSocketFactory(), x509TrustManager)
                .hostnameVerifier(DO_NOT_VERIFY);
        return builder.build();
    }

    private X509TrustManager x509TrustManager = new X509TrustManager() {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        @Override
        public void checkClientTrusted(
                java.security.cert.X509Certificate[] certs, String authType) {
        }

        @Override
        public void checkServerTrusted(
                java.security.cert.X509Certificate[] certs, String authType) {
        }
    };
    private TrustManager[] trustAllCerts = new TrustManager[]{x509TrustManager};

    private HostnameVerifier DO_NOT_VERIFY = (hostname, session) -> true;

    private SSLSocketFactory getTrustedSSLSocketFactory() {
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            return sc.getSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
