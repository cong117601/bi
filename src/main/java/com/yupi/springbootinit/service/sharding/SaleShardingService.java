package com.yupi.springbootinit.service.sharding;

import com.yupi.springbootinit.common.ErrorCode;
import com.yupi.springbootinit.exception.ThrowUtils;
import com.yupi.springbootinit.mapper.ChartMapper;
import com.yupi.springbootinit.model.entity.Sale;
import com.yupi.springbootinit.service.TableShardingContext;
import com.yupi.springbootinit.utils.CreateTableUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: CGM
 * @create: 2024-12-09 20:48
 */
@Service
@Slf4j
public class SaleShardingService implements TableStrategy {
    @Resource
    private ChartMapper chartMapper;
    @Resource
    private TableShardingContext context;

    @PostConstruct
    public void init() {
        context.strategyMap.put("sale", this);
    }

    @Override
    public String createTable(Long chartId) {
        String tableName = "";
        try {
            tableName = String.format("sale_%s", chartId);
            List<String> columns = CreateTableUtils.SALE_COLUMNS;
            chartMapper.createTable(tableName, columns);
        } catch (Exception e) {
            ThrowUtils.throwIf(true, ErrorCode.SYSTEM_ERROR, "销售留存表创建失败");
        }
        return tableName;
    }

    @Override
    public void insertData(List<Map<Integer, String>> lists, String tableName) {
        try {
            List<Sale> dataList = CreateTableUtils.getSales(lists);
            // 执行数据插入操作（具体实现不在此处展示）
            chartMapper.insertSaleTable(dataList, tableName);
        } catch (Exception e) {
            log.error("销售留存表插入失败", e.getMessage());
            ThrowUtils.throwIf(true, ErrorCode.SYSTEM_ERROR, "销售留存表插入失败");
        }

    }
}
