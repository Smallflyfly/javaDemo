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
 * @author fangpf
 * 2019.12.30
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
}