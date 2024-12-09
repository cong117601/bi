package com.yupi.springbootinit.mapper;

import com.yupi.springbootinit.model.entity.Chart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yupi.springbootinit.model.entity.Purchase;
import com.yupi.springbootinit.model.entity.Sale;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 * @Entity com.yupi.springbootinit.model.entity.Chart
 */
public interface ChartMapper extends BaseMapper<Chart> {

    List<Map<String, Object>> queryChartData(String querySql);

    boolean createTable(@Param("tableName") String tableName, @Param("columns") List<String> columns);

    boolean insertSaleTable(@Param("list") List<Sale> list, @Param("tableName") String tableName);

    boolean insertPurchaseTable(@Param("list") List<Purchase> list, @Param("tableName") String tableName);
}




