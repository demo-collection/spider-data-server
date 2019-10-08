package com.spider.data.server.spider.repository;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.spider.data.server.spider.entity.StoreEntity;
import com.spider.data.server.spider.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "storeRepository")
public class StoreRepository {
    @Autowired
    private StoreMapper storeMapper;

    /**
     * 查询全部
     * @return return
     */
    public List<StoreEntity> findByQuery(String query) {
        return storeMapper.findByQuery(query);
    }

    public Page<StoreEntity> query(
            String query,
            String page,
            String size
    ) {
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(size));
        return storeMapper.query(query);
    }
}
