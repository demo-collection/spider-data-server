package com.spider.data.server.spider.data.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class FindStoreList {
    @JSONField
    private String query;

    @JSONField
    private String order;
}
