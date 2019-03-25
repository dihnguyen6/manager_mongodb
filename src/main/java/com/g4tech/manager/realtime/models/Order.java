package com.g4tech.manager.realtime.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@Document(collection = "order")
public class Order {
    @Id
    private ObjectId id;
    @DBRef(lazy = true)
    private Product product;
    private String quantity;
    private ZonedDateTime orderTime;
    private String table;
    private boolean isDone;

    public Order(String table, Product product, String quantity) {
        this.table = table;
        this.product = product;
        this.quantity = quantity;
        this.isDone = false;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public ZonedDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(ZonedDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }

    public String getId() {
        return id.toHexString();
    }
}
