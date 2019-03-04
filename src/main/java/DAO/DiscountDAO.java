/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.sql.DataSource;

/**
 *
 * @author KAMDOM Merveille
 */
public class DiscountDAO {
     protected  DataSource  myDataSource ;

    public DiscountDAO(DataSource myDataSource) {
        this.myDataSource = myDataSource;
    }
     
}
