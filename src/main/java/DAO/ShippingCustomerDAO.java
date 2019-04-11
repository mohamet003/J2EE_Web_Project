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
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import models.ShippingForCustomer;

/**
 *
 * @author kevin
 */
public class ShippingCustomerDAO {
    protected  DataSource  myDataSource ;

    public ShippingCustomerDAO(DataSource myDataSource) {
        this.myDataSource = myDataSource;
    }

    
     public List<ShippingForCustomer> GetCaByIDCustomer(int customerID) throws DAOException {
                List<ShippingForCustomer> LShipping = new LinkedList<>();
		String sql = "SELECT SHIPPING_DATE, SUM(SHIPPING_COST*QUANTITY) AS PRIX FROM APP.PURCHASE_ORDER INNER JOIN APP.CUSTOMER USING(CUSTOMER_ID) WHERE CUSTOMER_ID = ? GROUP BY SHIPPING_DATE";
		
	try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
			PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setInt(1, customerID );
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
                                        ShippingForCustomer d = new ShippingForCustomer();
                                        d.SetCA(rs.getInt("PRIX"));
					d.SetDate(rs.getString("SHIPPING_DATE"));
                                        LShipping.add(d);
				} 
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}

		return LShipping;
	} 
}
