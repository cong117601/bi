package com.yupi.springbootinit.service.sharding;

import com.yupi.springbootinit.common.ErrorCode;
import com.yupi.springbootinit.exception.ThrowUtils;
import com.yupi.springbootinit.mapper.ChartMapper;
import com.yupi.springbootinit.model.entity.Purchase;
import com.yupi.springbootinit.model.entity.Sale;
import com.yupi.springbootinit.service.TableShardingContext;
import com.yupi.springbootinit.utils.CreateTableUtils;
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
public class PurchaseShardingService implements TableStrategy {
    @Resource
    private ChartMapper chartMapper;

    @Resource
    private TableShardingContext context;

    @PostConstruct
    public void init() {
        context.strategyMap.put("purchase", this);
    }

    @Override
    public String createTable(Long chartId) {
        String tableName = "";
        try {
            tableName = String.format("purchase_%s", chartId);
            List<String> columns = CreateTableUtils.PURCHASE_COLUMNS;
            chartMapper.createTable(tableName, columns);

        } catch (Exception e) {
            ThrowUtils.throwIf(true, ErrorCode.SYSTEM_ERROR, "采购留存表创建失败");
        }
        return tableName;
    }

    @Override
    public void insertData(List<Map<Integer, String>> lists,String tableName) {
        try {
            List<Purchase> dataList = CreateTableUtils.getPurchases(lists);
            // 执行数据插入操作（具体实现不在此处展示）
            chartMapper.insertPurchaseTable(dataList,tableName);
        } catch (Exception e) {
            ThrowUtils.throwIf(true, ErrorCode.SYSTEM_ERROR, "采购留存插入数据失败");
        }

    }
}
