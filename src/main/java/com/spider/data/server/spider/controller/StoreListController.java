package com.spider.data.server.spider.controller;


import com.alibaba.fastjson.JSONObject;
import com.spider.data.server.spider.data.BaseResponse;
import com.spider.data.server.spider.data.PageInfo;
import com.spider.data.server.spider.entity.StoreEntity;
import com.spider.data.server.spider.service.StoreService;
import com.spider.data.server.spider.utils.JsonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        List<StoreEntity> storeEntityList = storeService.findByQuery(query);
        if (storeEntityList.size() == 0) {
            return BaseResponse.responseError("请求失败");
        }
        return BaseResponse.responseSuccess(storeEntityList, "请求成功");
    }

    @PostMapping(value = "/update_is_looked", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse updateIsLooked(HttpServletRequest request) {
        StoreEntity storeEntity;
        try {
            String requestId = JsonRequest.getPayload(request);
            storeEntity = JSONObject.parseObject(requestId, StoreEntity.class);
            storeService.updateIsLooked(storeEntity.getId().toString());
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.responseError(e.getMessage());
        }
        return BaseResponse.responseSuccess(null, "success");
    }
}
