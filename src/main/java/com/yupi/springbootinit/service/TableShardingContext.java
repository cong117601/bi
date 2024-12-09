package com.yupi.springbootinit.service;/**
 * @description:
 * @author: CGM
 * @create: 2024-12-09 20:57
 */


import com.yupi.springbootinit.service.sharding.TableStrategy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class TableShardingContext {


    public static Map<String, TableStrategy> strategyMap = new ConcurrentHashMap<>(2);

    // 执行创建表操作 插入数据操作
    public void doCreateTableAndInsert(String strategyKey, Long chartId, List<Map<Integer, String>> lists) {
        TableStrategy strategy = strategyMap.get(strategyKey);
        String table = strategy.createTable(chartId);
        strategy.insertData(lists, table);
    }

}


