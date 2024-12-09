package com.yupi.springbootinit.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description: 销售表
 * @author: CGM
 * @create: 2024-12-09 19:29
 */
public class Purchase {

    private String purchaseNo;

    private String productName;

    private String providerName;
    private Integer quantity;

    private BigDecimal unitPrice;

    private BigDecimal totalPrice;


    private Date providerDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public String getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(String purchaseNo) {
        this.purchaseNo = purchaseNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getProviderDate() {
        return providerDate;
    }

    public void setProviderDate(Date providerDate) {
        this.providerDate = providerDate;
    }
}
