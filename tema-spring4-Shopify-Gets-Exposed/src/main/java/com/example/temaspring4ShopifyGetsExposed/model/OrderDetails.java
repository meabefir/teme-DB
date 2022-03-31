package com.example.temaspring4ShopifyGetsExposed.model;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Builder
public class OrderDetails implements Cloneable {
    private int id;
    private int quantity;
    private double priceEach;
    private int orderId;
    private String productCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }



    @Override
    public Object clone()throws CloneNotSupportedException{
        return (OrderDetails)super.clone();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "quantity=" + quantity +
                ", priceEach=" + priceEach +
                ", productCode='" + productCode + '\'' +
                '}';
    }

    public OrderDetails() {

    }

    public OrderDetails(int id, int quantity, double priceEach, int orderId, String productCode) {
        this.id = id;
        this.quantity = quantity;
        this.priceEach = priceEach;
        this.orderId = orderId;
        this.productCode = productCode;
    }

    public OrderDetails(int quantity, double priceEach, String productCode) {
        this.quantity = quantity;
        this.priceEach = priceEach;
        this.productCode = productCode;
    }
}
