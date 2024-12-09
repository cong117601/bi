package com.yupi.springbootinit.utils;

import com.yupi.springbootinit.model.entity.Purchase;
import com.yupi.springbootinit.model.entity.Sale;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: CGM
 * @create: 2024-12-09 18:55
 */
@Slf4j
public class CreateTableUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final List<String> SALE_COLUMNS = Arrays.asList(
            "sale_no VARCHAR(255) NOT NULL COMMENT '销售单号'",
            "product_name VARCHAR(255) NOT NULL COMMENT '产品名称'",
            "customer_name VARCHAR(255) NOT NULL COMMENT '客户名'",
            "quantity INT NOT NULL COMMENT '数量'",
            "unit_price DECIMAL(20, 6) NOT NULL COMMENT '单价'",
            "total_price DECIMAL(20, 6) NOT NULL COMMENT '总价'",
            "sale_date datetime NOT NULL COMMENT '销售日期'"
    );

    public static final List<String> PURCHASE_COLUMNS = Arrays.asList(
            "purchase_no VARCHAR(255) NOT NULL COMMENT '采购单号'",
            "product_name VARCHAR(255) NOT NULL COMMENT '产品名称'",
            "provider_name VARCHAR(255) NOT NULL COMMENT '供应商'",
            "quantity INT NOT NULL COMMENT '数量'",
            "unit_price DECIMAL(20, 6) NOT NULL COMMENT '单价'",
            "total_price DECIMAL(20, 6) NOT NULL COMMENT '总价'",
            "purchase_date datetime NOT NULL COMMENT '采购日期'"
    );

    public static List<Sale> getSales(List<Map<Integer, String>> lists) {
        List<Sale> salesList = lists.stream().map(row -> {
                    try {
                        Sale sale = new Sale();
                        sale.setSaleNo(row.get(0)); // 销售单号
                        sale.setProductName(row.get(1)); // 产品名称
                        sale.setCustomerName(row.get(2)); // 客户名
                        sale.setQuantity(row.get(3) != null ? Integer.parseInt(row.get(3)) : null); // 数量
                        sale.setUnitPrice(row.get(4) != null ? new BigDecimal(row.get(4)) : null); // 单价
                        sale.setTotalPrice(row.get(5) != null ? new BigDecimal(row.get(5)) : null); // 总价
                        sale.setSaleDate(row.get(6) != null ? sdf.parse(row.get(6)) : null); // 销售日期
                        return sale;
                    } catch (Exception e) {
                        log.error("行数据解析失败: {}", row, e);
                        return null; // 返回 null 以过滤掉无效数据
                    }
                }).filter(Objects::nonNull) // 过滤掉转换失败的行
                .collect(Collectors.toList());
        return salesList;
    }

    public static List<Purchase> getPurchases(List<Map<Integer, String>> lists) {
        List<Purchase> purchasesList = lists.stream().map(row -> {
                    try {
                        Purchase purchase = new Purchase();
                        purchase.setPurchaseNo(row.get(0)); // 销售单号
                        purchase.setProductName(row.get(1)); // 产品名称
                        purchase.setProviderName(row.get(2)); // 客户名
                        purchase.setQuantity(row.get(3) != null ? Integer.parseInt(row.get(3)) : null); // 数量
                        purchase.setUnitPrice(row.get(4) != null ? new BigDecimal(row.get(4)) : null); // 单价
                        purchase.setTotalPrice(row.get(5) != null ? new BigDecimal(row.get(5)) : null); // 总价
                        purchase.setProviderDate(row.get(6) != null ? sdf.parse(row.get(6)) : null); // 销售日期
                        return purchase;
                    } catch (Exception e) {
                        log.error("行数据解析失败: {}", row, e);
                        return null; // 返回 null 以过滤掉无效数据
                    }
                }).filter(Objects::nonNull) // 过滤掉转换失败的行
                .collect(Collectors.toList());
        return purchasesList;
    }



}
