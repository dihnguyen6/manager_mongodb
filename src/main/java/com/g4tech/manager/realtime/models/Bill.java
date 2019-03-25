package com.g4tech.manager.realtime.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.List;

@Document(collection = "bill")
public class Bill {

    @Id
    private ObjectId id;

    private List<Order> orders;
    private ZonedDateTime checkoutTime;

    public Bill(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public ZonedDateTime getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(ZonedDateTime checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public String getId() {
        return id.toHexString();
    }
}
