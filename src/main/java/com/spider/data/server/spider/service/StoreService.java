package com.spider.data.server.spider.service;

import com.spider.data.server.spider.data.PageInfo;
import com.spider.data.server.spider.entity.StoreEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoreService {
    PageInfo<StoreEntity> findAll(String query, String order, String page, String size);

    List<StoreEntity> findByQuery(String query);

    void updateIsLooked(String id);

    void updateIsDownLoad(String id);
}
