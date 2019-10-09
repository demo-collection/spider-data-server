package com.spider.data.server.spider.service;

import com.spider.data.server.spider.entity.StoreEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoreService {
    List<StoreEntity> findAll(String query, String order, String page, String size);
}
