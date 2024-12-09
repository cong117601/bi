package com.yupi.springbootinit.mapper;

import com.yupi.springbootinit.utils.CreateTableUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChartMapperTest {

    @Resource
    private ChartMapper chartMapper;

    @Test
    void queryChartData() {
        String chartId = "1659210482555121666";
        String querySql = String.format("select * from chart_%s", chartId);
        List<Map<String, Object>> resultData = chartMapper.queryChartData(querySql);
        System.out.println(resultData);
    }

    @Test
    void createTable(){
        String chartId = "1659210482555121666";
        String userId = "1865043913836900354";
        List<String> columns = CreateTableUtils.SALE_COLUMNS;
        String tableName = String.format("sale_%s_%s", chartId,userId);
        chartMapper.createTable(tableName,columns);

//        columns = CreateTableUtils.BUY_COLUMNS;
//        tableName = String.format("purchase_%s_%s", chartId,userId);
//        chartMapper.createTable(tableName,columns);
    }
}