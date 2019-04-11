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
public class CACategorieDAO {
    
    protected  DataSource  myDataSource ;
    
    public CACategorieDAO(DataSource myDataSource) {
        this.myDataSource = myDataSource;
    }
    
    public List<ShippingForCustomer> GetCaByCategorie(String PRODUCT_CODE) throws DAOException {
                List<ShippingForCustomer> LShipping = new LinkedList<>();
		String sql = "SELECT PRODUCT_CODE,SHIPPING_DATE,SUM(SHIPPING_COST*QUANTITY) AS PRIX FROM APP.PRODUCT_CODE INNER JOIN(APP.PRODUCT INNER JOIN APP.PURCHASE_ORDER USING(PRODUCT_ID)) ON PROD_CODE = PRODUCT_CODE GROUP BY SHIPPING_DATE,PRODUCT_CODE  HAVING PRODUCT_CODE = ? ";
	try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
			PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, PRODUCT_CODE);
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
