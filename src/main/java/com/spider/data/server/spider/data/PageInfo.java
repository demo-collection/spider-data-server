package com.spider.data.server.spider.data;

import com.github.pagehelper.PageSerializable;
import lombok.Data;

@Data
public class PageInfo<T> extends PageSerializable<T> {
    private int pageNum;
    private int pageSize;
}
