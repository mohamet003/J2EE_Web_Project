/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author admin
 */
public class Product_Code {
    
    private String Prod_Code;
    private String discount_code;
    private String description;

    public String getProd_Code() {
        return Prod_Code;
    }

    public void setProd_Code(String Prod_Code) {
        this.Prod_Code = Prod_Code;
    }

    public String getDiscount_code() {
        return discount_code;
    }

    public void setDiscount_code(String discount_code) {
        this.discount_code = discount_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
