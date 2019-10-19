# spider-data-server

我不是爬虫， 我只是做处理爬虫获取的数据。我只是一个后端服务 ~~


sql                 
```mysql
create database if not exists spider1;

CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key_word` varchar(10) NOT NULL,
  `title` varchar(100) NOT NULL,
  `detail_url` varchar(200) NOT NULL,
  `download_url` mediumtext,
  `look_over` int(6) DEFAULT NULL,
  `reply` int(6) DEFAULT NULL,
  `is_looked` tinyint(1) DEFAULT NULL,
  `is_download` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40046 DEFAULT CHARSET=utf8;
```

