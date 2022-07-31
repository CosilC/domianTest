package com.domaintest.domain;

import lombok.Data;

import java.util.List;

/**
 * 响应-获取测试节点
 */
@Data
public class GetAllNodesResponse {
    /**
     * token
     */
    private String token;
    /**
     * 节点数
     */
    private Integer nodescount;
    /**
     * 节点列表
     */
    private List<Nodes> nodes;
}
