package com.domaintest.domain;

import lombok.Data;

/**
 * 响应-获取ip的区域信息
 */
@Data
public class GetIpAreaResponse {
    /**
     * ip
     */
    private String ip;
    /**
     * 国家
     */
    private String country;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * isp
     */
    private String isp;
}
