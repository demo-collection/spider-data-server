package com.spider.data.server.spider.mapper;

import com.github.pagehelper.Page;
import com.spider.data.server.spider.entity.StoreEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "storeMapper")
public interface StoreMapper {
    List<StoreEntity> findAll();

    Page<StoreEntity> query(String query);

    Page<StoreEntity> findByQuery(String query);

    void updateIsLooked(String id);

    void updateIsDownLoad(String id);
}
