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
import models.Discount_Code;
import models.Purchase_Order;

/**
 *
 * @author KAMDOM Merveille
 */
public class DiscountDAO {
     protected  DataSource  myDataSource ;

    public DiscountDAO(DataSource myDataSource) {
        this.myDataSource = myDataSource;
    }
     public Discount_Code GetDiscountByID(char discount_code) throws DAOException {
                Discount_Code d = new Discount_Code();
		String sql = "SELECT * FROM PURCHASE_ORDER WHERE ORDER_NUM = ? ";
		
	try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
			PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setInt(1, discount_code );
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) { // On a trouvé
                                        d.setDiscount_code(discount_code);
					d.setRate(rs.getFloat("RATE"));
 			
				} 
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}

		return d;
	} 
}
