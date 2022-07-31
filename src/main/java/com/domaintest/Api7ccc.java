package com.domaintest;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.net.URLEncodeUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.domaintest.domain.GetAllNodesResponse;
import com.domaintest.domain.GetIpAreaResponse;
import com.domaintest.domain.GetNodeResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

/**
 * 域名测试网站<a href="https://7c.cc/">7c.cc</a>的api
 */
@Slf4j
public class Api7ccc {
    public static final String API_URL = "https://7c.cc/ceController.php";
    public static final Integer TIMEOUT = 3000;

    /**
     * @param ExISP 排除的isp
     * @return 获取条件内的所有节点
     */
    public static GetAllNodesResponse getAllNodes(String... ExISP) {
        String responseStr = HttpUtil.post(API_URL, new HashMap<String, Object>() {{
            put("type", "getAllNodes");
            put("act", "GET");
            put("isp", ExISP);
        }});
        return JSON.parseObject(responseStr, GetAllNodesResponse.class);
    }

    /**
     * @param nodeSeq   节点序号
     * @param targetUrl 测试域名
     * @return 节点的测试结果
     */
    public static GetNodeResultResponse getNodeResult(String nodeSeq, String targetUrl) {
        return getNodeResult(nodeSeq, targetUrl, null);
    }

    /**
     * @param nodeSeq   节点序号
     * @param targetUrl 测试域名
     * @param token     token(可选，用于区分测试的分享链接)
     * @return 节点的测试结果
     */
    public static GetNodeResultResponse getNodeResult(String nodeSeq, String targetUrl, String token) {
        try {
            String responseStr = HttpUtil.post(API_URL, new HashMap<String, Object>() {{
                put("type", "getNodeResult");
                put("url", URLEncodeAndToBase64(targetUrl));
                put("seq", nodeSeq);
                if (StringUtils.isNotBlank(token)) {
                    put("token", token);
                }
                //不要连接头，提高性能并节省流量
                put("getheader", "no");
            }}, TIMEOUT);
            return JSON.parseObject(responseStr, GetNodeResultResponse.class);
        } catch (Exception e) {
            log.warn("访问超时::seq{},targetUrl{},token{}", nodeSeq, targetUrl, token);
            return GetNodeResultResponse.builder().statuscode("502").seq(nodeSeq).build();
        }
    }

    /**
     * @param targetIp 目标ip
     * @return 目标ip的区域信息
     */
    public static GetIpAreaResponse getIpArea(String targetIp) {
        String responseStr = HttpUtil.post(API_URL, new HashMap<String, Object>() {{
            put("type", "getIpLoc");
            put("ip", targetIp);
        }});
        return JSON.parseObject(responseStr, GetIpAreaResponse.class);
    }

    /**
     * @param url 目标url
     * @return 先url编码后base64编码的String
     */
    private static String URLEncodeAndToBase64(String url) {
        return Base64.encode(URLEncodeUtil.encodeAll(url));
    }
}
