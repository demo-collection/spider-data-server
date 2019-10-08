package com.spider.data.server.spider.data.qo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class CreateEvent {
    @JSONField
    private String platform;

    @JSONField
    private String eventKey;

    @JSONField
    private String description;
}
