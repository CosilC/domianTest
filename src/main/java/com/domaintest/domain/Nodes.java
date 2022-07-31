package com.domaintest.domain;

import lombok.Data;

@Data
public class Nodes {
    /**
     * 序号
     */
    private String seq;
    /**
     * 国+省
     */
    private String country;
    /**
     * 城市
     */
    private String city;
    /**
     * ip
     */
    private String ip;
    /**
     * 对应isp
     */
    private String isp;

    private String name;
    private String country2;
    private String city2;
    private String isp2;
    private String type;
}
