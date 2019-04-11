/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author kevin
 */
public class ShippingForCustomer {
    
    private int CA;
    private String date;

    public ShippingForCustomer() {
    }

    public int getCA(){
        return CA;
    }
    
    public void SetCA(int CA){
        this.CA = CA;
    }
    
     public String getDate(){
        return date;
    }
    
    public void SetDate(String date){
        this.date = date;
    }

}

