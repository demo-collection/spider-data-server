package com.spider.data.server.spider.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreServiceImplTest {

    @Autowired
    private StoreServiceImpl storeService;

    @Test
    public void findAll() {
    }

    @Test
    public void findByQuery() {
    }

    @Test
    public void updateIsLooked() {
        storeService.updateIsLooked("1");
    }
}