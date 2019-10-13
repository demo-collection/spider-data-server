package com.spider.data.server.spider.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.spider.data.server.spider.data.PageInfo;
import com.spider.data.server.spider.entity.StoreEntity;
import com.spider.data.server.spider.mapper.StoreMapper;
import com.spider.data.server.spider.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreMapper storeMapper;

    @Override
    public PageInfo<StoreEntity> findAll(String query, String order, String page, String size) {
        String orderString = !StringUtils.isEmpty(order) ? order + " desc" : "";
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(size), orderString);
        Page<StoreEntity> storeEntityPage = storeMapper.findByQuery(query);

        PageInfo<StoreEntity> pageInfo = new PageInfo<StoreEntity>();
        pageInfo.setList(storeEntityPage);
        pageInfo.setPageNum(storeEntityPage.getPageNum());
        pageInfo.setPageSize(storeEntityPage.getPageSize());
        pageInfo.setTotal(storeEntityPage.getTotal());
        return pageInfo;
    }

    @Override
    public List<StoreEntity> findByQuery(String query) {
        return storeMapper.query(query);
    }
}
