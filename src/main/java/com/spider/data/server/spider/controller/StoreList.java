package com.spider.data.server.spider.controller;


import com.spider.data.server.spider.data.BaseResponse;
import com.spider.data.server.spider.entity.StoreEntity;
import com.spider.data.server.spider.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/store")
public class StoreList {
    @Autowired
    private StoreService storeService;

    @GetMapping("/list")
    public BaseResponse list(
            @RequestParam(name = "query", required = false) String query,
            @RequestParam(name = "page", defaultValue = "1") String page,
            @RequestParam(name = "size", defaultValue = "20") String size
    ) {
        List<StoreEntity> list = storeService.findAll(query, page, size);
        if (list != null) {
            System.out.println(list.size());
            return BaseResponse.responseSuccess(list, "请求成功");
        }
        return BaseResponse.responseError("请求失败");
    }
}
