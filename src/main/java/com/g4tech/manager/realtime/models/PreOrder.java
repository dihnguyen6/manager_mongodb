package com.g4tech.manager.realtime.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "preorder")
public class PreOrder {

    @Id
    private ObjectId id;

    private Product product;
    private int quantity;
    private boolean isEditable;
    private boolean isDone;

    public PreOrder() {
    }

    public PreOrder(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ObjectId getId() {
        return id;
    }
}
