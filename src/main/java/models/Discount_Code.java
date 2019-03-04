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
public class Discount_Code {
         char discount_code;
         float rate;

    public Discount_Code(char discount_code, float rate) {
        this.discount_code = discount_code;
        this.rate = rate;
    }

    public Discount_Code() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public char getDiscount_code() {
        return discount_code;
    }

    public void setDiscount_code(char discount_code) {
        this.discount_code = discount_code;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
    
    
}
