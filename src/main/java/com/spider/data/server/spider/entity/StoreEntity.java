package com.spider.data.server.spider.entity;

import lombok.Data;

@Data
public class StoreEntity {
    private Integer id;

    // 关键词
    private String keyWord;

    private String title;

    // 详情页面的url
    private String detailUrl;

    // 下载链接
    private String downLoadUrl;

    // 浏览量
    private Integer lookOver;

    // 回复量
    private Integer reply;
}
