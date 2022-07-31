package com.domaintest.controller;

import com.domaintest.Api7ccc;
import com.domaintest.domain.GetAllNodesResponse;
import com.domaintest.domain.GetIpAreaResponse;
import com.domaintest.domain.GetNodeResultResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    /**
     * 获取除海外isp的所有测试节点
     */
    @GetMapping("getAllNodes")
    public GetAllNodesResponse getAllNodes() {
        return Api7ccc.getAllNodes("12");
    }

    /**
     * 获取除海外isp的所有测试节点
     */
    @PostMapping("getNodeResult")
    public GetNodeResultResponse getNodeResult(String nodeSeq, String targetUrl, String token) {
        return Api7ccc.getNodeResult(nodeSeq, targetUrl, token);
    }

    /**
     * 获取目标ip的地理信息
     */
    @PostMapping("getIpArea")
    public GetIpAreaResponse getIpArea(String targetIp) {
        return Api7ccc.getIpArea(targetIp);
    }

}
