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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class CAZoneGeographiqueDAO {
    protected  DataSource  myDataSource ;
    
    public CAZoneGeographiqueDAO(DataSource myDataSource) {
        this.myDataSource = myDataSource;
    }
    
    public List<ShippingForCustomer> GetCaByZoneGeo(String zone,String dateD, String dateF) throws DAOException, ParseException {
                List<ShippingForCustomer> LShipping = new LinkedList<>();
		String sql = "SELECT PURCHASE_ORDER.SALES_DATE, \n" +
"SUM(((PURCHASE_ORDER.QUANTITY * PRODUCT.PURCHASE_COST) - ((PURCHASE_ORDER.QUANTITY * PRODUCT.PURCHASE_COST )*RATE)/100) + SHIPPING_COST) as CA \n" +
"FROM CUSTOMER INNER JOIN PURCHASE_ORDER USING(CUSTOMER_ID) \n" +
"INNER JOIN PRODUCT USING(PRODUCT_ID)\n" +
"INNER JOIN PRODUCT_CODE ON (PRODUCT_CODE = PROD_CODE)\n" +
"INNER JOIN DISCOUNT_CODE ON (DISCOUNT_CODE.DISCOUNT_CODE = PRODUCT_CODE.DISCOUNT_CODE)\n" +
"WHERE ZIP = ? AND PURCHASE_ORDER.SALES_DATE BETWEEN ? AND ? \n" +
"GROUP BY (SALES_DATE)";
	try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
			PreparedStatement stmt = connection.prepareStatement(sql)) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
                        Date dateDe = sdf.parse(dateD);
                        Date dateFi = sdf.parse(dateF);
                        String dde = sdf.format(dateDe); 
                        String dfi = sdf.format(dateFi); 

			stmt.setString(1, zone);
                        stmt.setString(2, dateD );
                        stmt.setString(3, dateF );
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
                                        ShippingForCustomer d = new ShippingForCustomer();
                                        d.SetCA(rs.getInt("CA"));
					d.SetDate(rs.getString("SALES_DATE"));
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
