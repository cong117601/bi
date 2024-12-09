package com.yupi.springbootinit.service.sharding;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: CGM
 * @create: 2024-12-09 20:47
 */
public interface TableStrategy {
    // 创建表的方法
    String createTable(Long chartId);

    // 插入数据的方法
    void insertData(List<Map<Integer, String>> list,String tableName);
}
