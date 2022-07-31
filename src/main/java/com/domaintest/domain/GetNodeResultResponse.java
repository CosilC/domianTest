package com.domaintest.domain;

import lombok.Builder;
import lombok.Data;

/**
 * 响应-节点测试情况
 */
@Data
@Builder
public class GetNodeResultResponse {
    /**
     * 连接时间
     */
    private Double conntime;
    /**
     * 下载大小
     */
    private String downsize;
    /**
     * 下载速度
     */
    private Double downspeed;
    /**
     * 下载时间
     */
    private String downtime;
    /**
     * 首字节时间
     */
    private Double firstbytetime;
    /**
     * 连接头
     */
    private String header;
    /**
     * 解析域名ip
     */
    private String ip;
    /**
     * 解析时间
     */
    private Double nslookuptime;
    /**
     * 节点序号
     */
    private String seq;
    /**
     * 文件大小
     */
    private String size;
    /**
     * http状态
     */
    private String statuscode;
    /**
     * 总时间
     */
    private Double totaltime;
}
