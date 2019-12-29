package com.wochanye.demo.config;


import com.dangdang.config.service.ConfigGroup;
import com.dangdang.config.service.zookeeper.ZookeeperConfigGroup;
import com.dangdang.config.service.zookeeper.ZookeeperConfigProfile;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author song
 * 2018年7月26日 下午6:32:14 
 * email:jiangqs3@chinaunicom.cn 
 */
@Configuration
public class ConfigToolkitConfig {
 
 
    /**
     * 配置zk管理中心
     * @param connectStr
     * @param rootNode
     * @param version
     * @return
     */
    @Bean
    public ZookeeperConfigProfile getConfigProfile(@Value("${config-toolkit.connect-str}") String connectStr,
            @Value("${config-toolkit.root-node}") String rootNode,
            @Value("${config-toolkit.version}") String version) {
        return new ZookeeperConfigProfile(connectStr, rootNode, version);
    }

    /**
     * 百度地址配置测试
     */
    @Bean("apiUrlConfig")
    public ConfigGroup getApplicationGroup(ZookeeperConfigProfile configProfile) {
        System.out.println(configProfile.getRootNode());
        return new ZookeeperConfigGroup(configProfile, "apiUrl");
    }
 
 
//    /**
//     * 数据源等配置
//     * @param configProfile
//     * @return
//     */
//    @Bean("mysqlConfig")
//    public ConfigGroup getApplicationGroup(ZookeeperConfigProfile configProfile) {
//        return new ZookeeperConfigGroup(configProfile, "mysql");
//    }
 
 
//    /**
//     * 环境变量配置
//     * @param configProfile
//     * @return
//     */
//    @Bean("envConfig")
//    public ConfigGroup getEnvGroup(ZookeeperConfigProfile configProfile) {
//        return new ZookeeperConfigGroup(configProfile, "env");
//    }
//
//
//    /**
//     * mongodb配置
//     * @param configProfile
//     * @return
//     */
//    @Bean("mongodbConfig")
//    public ConfigGroup getPathGroup(ZookeeperConfigProfile configProfile) {
//        return new ZookeeperConfigGroup(configProfile, "mongodb");
//    }
//
//    /**
//     * 短信配置
//     * @param configProfile
//     * @return
//     */
//    @Bean("smsConfig")
//    public ConfigGroup getSmsGroup(ZookeeperConfigProfile configProfile) {
//        return new ZookeeperConfigGroup(configProfile, "sms");
//    }
//
//    /**
//     * redis配置
//     * @param configProfile
//     * @return
//     */
//    @Bean("redisConfig")
//    public ConfigGroup getRedisGroup(ZookeeperConfigProfile configProfile) {
//        return new ZookeeperConfigGroup(configProfile, "redis");
//    }
//
//
//    /**
//     * MQ配置
//     * @param configProfile
//     * @return
//     */
//    @Bean("mqConfig")
//    public ConfigGroup getRocketmqGroup(ZookeeperConfigProfile configProfile) {
//        return new ZookeeperConfigGroup(configProfile, "mq");
//    }
//
//    /**
//     * arangodb配置
//     * @param configProfile
//     * @return
//     */
//    @Bean("arangodbConfig")
//    public ConfigGroup getArangodbGroup(ZookeeperConfigProfile configProfile) {
//        return new ZookeeperConfigGroup(configProfile, "arangodb");
//    }
//
//    /**
//     * apiUrl配置
//     * @param configProfile
//     * @return
//     */
//    @Bean("apiUrlConfig")
//    public ConfigGroup getApiUrlGroup(ZookeeperConfigProfile configProfile) {
//        return new ZookeeperConfigGroup(configProfile, "apiUrl");
//    }
//
//    /**
//     * socketIo配置
//     * @param configProfile
//     * @return
//     */
//    @Bean("socketIoConfig")
//    public ConfigGroup getSocketIoGroup(ZookeeperConfigProfile configProfile) {
//        return new ZookeeperConfigGroup(configProfile, "socketIo");
//    }
//
//    /**
//     * 有人透传云配置
//     * @param configProfile
//     * @return
//     */
//    @Bean("usrConfig")
//    public ConfigGroup getUsrConfig(ZookeeperConfigProfile configProfile) {
//        return new ZookeeperConfigGroup(configProfile, "usrConfig");
//    }
//
//    /**
//     * 有人透传云配置
//     * @param configProfile
//     * @return
//     */
//    @Bean("boatConfig")
//    public ConfigGroup getBoatConfig(ZookeeperConfigProfile configProfile) {
//        return new ZookeeperConfigGroup(configProfile, "boat");
//    }
//
//    @Bean
//    public RetryNTimes retryPolicy() {
//        return new RetryNTimes(10, 5000);
//    }
//
//    @Bean("curatorFramework")
//    public CuratorFramework client(@Value("${config-toolkit.connect-str}") String connectStr) {
//        CuratorFramework client = CuratorFrameworkFactory
//                .newClient(connectStr, 10000, 5000, retryPolicy());
//        client.start();
//        return client;
//    }
    
}