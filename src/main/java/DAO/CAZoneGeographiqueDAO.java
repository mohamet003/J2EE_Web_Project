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
import models.CustomerEntity;
import models.ShippingForCustomer;

/**
 *
 * @author kevin
 */
public class CAZoneGeographiqueDAO {
    protected  DataSource  myDataSource ;
    
    public CAZoneGeographiqueDAO(DataSource myDataSource) {
        this.myDataSource = myDataSource;
    }
    
    public List<ShippingForCustomer> GetCaByZoneGeo(String STATE) throws DAOException {
                List<ShippingForCustomer> LShipping = new LinkedList<>();
		String sql = "SELECT SHIPPING_DATE, STATE, SUM(SHIPPING_COST*QUANTITY) AS PRIX FROM APP.PURCHASE_ORDER INNER JOIN (APP.PRODUCT INNER JOIN APP.MANUFACTURER USING (MANUFACTURER_ID))USING(PRODUCT_ID) GROUP BY STATE, SHIPPING_DATE HAVING STATE = ? ";
	try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
			PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, STATE);
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
    
    
    
    public  List<String> findAllState() throws DAOException {
		List<String> LState = new LinkedList<>();
		String sql = "SELECT DISTINCT(STATE) FROM APP.MANUFACTURER";
                
		try (Connection connection = myDataSource.getConnection(); 
			PreparedStatement stmt = connection.prepareStatement(sql)) {

			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {                   
                                        LState.add(rs.getString("STATE"));
				} 
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}

		return LState;
	}
}
