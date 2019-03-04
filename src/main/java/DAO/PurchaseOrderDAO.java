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
import java.util.LinkedList;
import java.util.List;
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
	
   public Purchase_Order GetPurchaseOrderByCustomer(int customer_ID) throws DAOException {
Purchase_Order order = new Purchase_Order();
		String sql = "SELECT * FROM PURCHASE_ORDER WHERE CUSTOMER_ID = ? ";
		
	try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
			PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setInt(1, customer_ID);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) { // On a trouvé
					order.setCustomer_ID(customer_ID);
                                        order.setOrder_num(rs.getInt("ORDER_NUM"));
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
   
   public Purchase_Order GetPurchaseOrderByProduct (int product_ID) throws DAOException {
Purchase_Order order = new Purchase_Order();
		String sql = "SELECT * FROM PURCHASE_ORDER WHERE PRODUCT_ID = ? ";
		
	try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
			PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setInt(1, product_ID);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) { // On a trouvé
					order.setProduct_ID(product_ID);
                                        order.setOrder_num(rs.getInt("ORDER_NUM"));
                                        order.setCustomer_ID(rs.getInt("CUSTOMER_ID"));
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
   public Purchase_Order AddPurchaseOrder () throws DAOException {
      List<Purchase_Order> ListOrder = new LinkedList<>();
		String sql = "INSERT INTO PURCHASE_ORDER VALUES() ";
		
	try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
			PreparedStatement stmt = connection.prepareStatement(sql)) {

			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) { // On a trouvé
                                      Purchase_Order order = new Purchase_Order();
					order.getCustomer_ID();
                                        order.getOrder_num();
                                        order.getCustomer_ID();
                                        order.getShipping_cost();
                                        order.getQuantity();
					order.getSales_date();
                                        order.getshipping_date();
                                        order.getFreight_company();
                                    ListOrder.add(order);
				} 
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
     return null;
	}
}   

