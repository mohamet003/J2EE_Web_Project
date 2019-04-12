/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author KAMDOM Merveille
 */
public class Product {
    int product_ID;
    int manufacturer_ID;
    String product_code;
    float purchase_cost;
    int quantity_on_hand;
    float markup;
    boolean available;
    String description;
    float rate;

public Product (){}

    public int getProduct_ID() {
        return product_ID;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getManufacturer_ID() {
        return manufacturer_ID;
    }

    public String getProduct_code() {
        return product_code;
    }

    public float getPurchase_cost() {
        return purchase_cost;
    }

    public int getQuantity_on_hand() {
        return quantity_on_hand;
    }

    public float getMarkup() {
        return markup;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getDescription() {
        return description;
    }

    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
    }

    public void setManufacturer_ID(int manufacturer_ID) {
        this.manufacturer_ID = manufacturer_ID;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public void setPurchase_cost(float purchase_cost) {
        this.purchase_cost = purchase_cost;
    }

    public void setQuantity_on_hand(int quantity_on_hand) {
        this.quantity_on_hand = quantity_on_hand;
    }

    public void setMarkup(float markup) {
        this.markup = markup;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    
}
