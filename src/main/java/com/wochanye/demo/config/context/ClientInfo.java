package com.wochanye.demo.config.context;

import lombok.Data;

/**
 * @author fangpf
 * @date 2020/1/20 16:00
 */
@Data
public class ClientInfo {
    /**
     * 系统信息
     */
    private String systemInfo;
    /**
     * 详细信息
     */
    private String detailInfo;
}
