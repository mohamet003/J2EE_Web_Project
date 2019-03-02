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
import models.Product;
import models.Purchase_Order;

/**
 *
 * @author KAMDOM Merveille
 */
public class ProductDAO {
    protected  DataSource  myDataSource ;

    public ProductDAO(DataSource myDataSource) {
        this.myDataSource = myDataSource;
    }

	public Product GetAllProduct() throws DAOException {
                Product P = new Product();
		String sql = "SELECT * FROM PRODUCT ";
		
	try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
			PreparedStatement stmt = connection.prepareStatement(sql)) {

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) { // On a trouvé

					P.setProduct_ID(rs.getInt("PRODUCT_ID"));
                                        P.setPurchase_cost(rs.getInt("PURCHASE_COST"));
                                        P.setProduct_code(rs.getString("PRODUCT_CODE"));
                                        P.setPurchase_cost(rs.getFloat("PURCHASE_COST"));
                                        P.setQuantity_on_hand(rs.getInt("QUANTITY_ON_HAND"));
					P.setMarkup(rs.getFloat("MARKUP"));
                                        P.setAvailable(rs.getBoolean("AVAILABLE"));
                                        P.setDescription(rs.getString("DESCRIPTION"));
					// On crée l'objet "entity"
				
				} // else on n'a pas trouvé, on renverra null
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}

		return P;
	} 
}