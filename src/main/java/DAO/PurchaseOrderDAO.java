/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import database.DAOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import models.Purchase_Order;

/**
 *
 * @author KAMDOM Merveille
 */
public class PurchaseOrderDAO {
 protected  DataSource  myDataSource ;

    public PurchaseOrderDAO(DataSource myDataSource) {
        this.myDataSource = myDataSource;
    }

	public Purchase_Order GetPurchaseOrderByID(int order_num) throws DAOException {
Purchase_Order order = new Purchase_Order();
		String sql = "SELECT * FROM PURCHASE_ORDER WHERE ORDER_NUM = ? ";
		
	try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
			PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setInt(1, order_num);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) { // On a trouvé
                                        System.out.println("tesst");
					order.setOrder_num(order_num);
                                        order.setCustomer_ID(rs.getInt("CUSTOMER_ID"));
                                        order.setProduct_ID(rs.getInt("PRODUCT_ID"));
                                        order.setShipping_cost(rs.getFloat("SHIPPING_COST"));
                                        order.setQuantity(rs.getInt("QUANTITY"));
					order.setSales_date(rs.getDate("SALES_DATE"));
                                        order.setshipping_date(rs.getDate("SHIPPING_DATE"));
                                        order.setFreight_company(rs.getString("FREIGHT_COMPANY"));
					// On crée l'objet "entity"
				
				} // else on n'a pas trouvé, on renverra null
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}

		return order;
	} 
	

}   

