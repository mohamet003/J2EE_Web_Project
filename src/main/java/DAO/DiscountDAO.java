/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import database.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import models.Discount_code;
import models.Product;

/**
 *
 * @author KAMDOM Merveille
 */
public class DiscountDAO {
     protected  DataSource  myDataSource ;

    public DiscountDAO(DataSource myDataSource) {
        this.myDataSource = myDataSource;
    }

     
         public Discount_code GetDiscountByID(String DISCOUNT_CODE) throws DAOException {

        Discount_code p = new Discount_code();
        String sql = "SELECT * FROM DISCOUNT_CODE WHERE DISCOUNT_CODE = ? ";

        try ( Connection connection = myDataSource.getConnection(); 
                  PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, DISCOUNT_CODE);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    p.setRate(rs.getFloat("RATE"));
                    p.setDiscount_code(rs.getString("DISCOUNT_CODE"));
   
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getMessage());
        }

        return p;
    }

}
