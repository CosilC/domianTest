package com.domaintest;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.domaintest.constant.ISPConstants;
import org.junit.jupiter.api.Test;

//@SpringBootTest
class Api7cccTests {

    @Test
    void contextLoads() {
    }

    @Test
    void getAllNodesTest() {
        //获取除了海外isp以外的测试节点
        System.out.println(JSON.toJSONString(Api7ccc.getAllNodes(ISPConstants.ABROAD), JSONWriter.Feature.PrettyFormat));
    }

    @Test
    void getNodeResultTest() {
        // "seq": "152682",
        // "country": "中国辽宁",
        // "city": "锦州",
        // "ip": "42.7.91.7",
        // "isp": "联通",
        System.out.println(JSON.toJSONString(Api7ccc.getNodeResult("152682", "www.baidu.com", "A381E243BFF6673192"), JSONWriter.Feature.PrettyFormat));
    }

    @Test
    void getIpAreaTest() {
        // 180.101.49.12
        System.out.println(JSON.toJSONString(Api7ccc.getIpArea("180.101.49.12"), JSONWriter.Feature.PrettyFormat));
    }

}
