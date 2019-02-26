/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author KAMDOM Merveille
 */
public class Purchase_Order {
    int order_num;
    int custumer_ID;
    int product_ID;
    int quantity;
    float shipping_cost;
    Date sales_date;
    Date dshipping_date;
    String freight_company;

    public Purchase_Order(int order_num, int custumer_ID, int product_ID, int quantity, float shipping_cost, Date sales_date, Date dshipping_date, String freight_company) {
        this.order_num = order_num;
        this.custumer_ID = custumer_ID;
        this.product_ID = product_ID;
        this.quantity = quantity;
        this.shipping_cost = shipping_cost;
        this.sales_date = sales_date;
        this.dshipping_date = dshipping_date;
        this.freight_company = freight_company;
    }

    public int getOrder_num() {
        return order_num;
    }

    public int getCustumer_ID() {
        return custumer_ID;
    }

    public int getProduct_ID() {
        return product_ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getShipping_cost() {
        return shipping_cost;
    }

    public Date getSales_date() {
        return sales_date;
    }

    public Date getDshipping_date() {
        return dshipping_date;
    }

    public String getFreight_company() {
        return freight_company;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public void setCustumer_ID(int custumer_ID) {
        this.custumer_ID = custumer_ID;
    }

    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setShipping_cost(float shipping_cost) {
        this.shipping_cost = shipping_cost;
    }

    public void setSales_date(Date sales_date) {
        this.sales_date = sales_date;
    }

    public void setDshipping_date(Date dshipping_date) {
        this.dshipping_date = dshipping_date;
    }

    public void setFreight_company(String freight_company) {
        this.freight_company = freight_company;
    }
    
}
