package com.spider.data.server.spider.controller;


import com.spider.data.server.spider.data.BaseResponse;
import com.spider.data.server.spider.data.PageInfo;
import com.spider.data.server.spider.entity.StoreEntity;
import com.spider.data.server.spider.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/store")
public class StoreListController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/list")
    public BaseResponse list(
            @RequestParam(name = "query", required = false) String query,
            @RequestParam(name = "order", required = false) String order,
            @RequestParam(name = "page", defaultValue = "1") String page,
            @RequestParam(name = "size", defaultValue = "20") String size
    ) {
        PageInfo<StoreEntity> list = storeService.findAll(query, order, page, size);
        if (list != null) {
            return BaseResponse.responseSuccess(list, "请求成功");
        }
        return BaseResponse.responseError("请求失败");
    }

    @GetMapping("/search")
    public BaseResponse search(
            @RequestParam(name = "query", defaultValue = "") String query
    ) {
        PageInfo<StoreEntity> storeEntityPageInfo = storeService.findByQuery(query);
        return BaseResponse.responseSuccess(storeEntityPageInfo, "请求成功");
    }
}
