package com.spider.data.server.spider.service.impl;

import com.github.pagehelper.PageHelper;
import com.spider.data.server.spider.entity.StoreEntity;
import com.spider.data.server.spider.repository.StoreRepository;
import com.spider.data.server.spider.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<StoreEntity> findAll(String query, String order, String page, String size) {
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(size));
        if (order != null) {
            return storeRepository.findByQueryAndOrder(query, order);
        }
        return storeRepository.findByQuery(query);
    }
}
