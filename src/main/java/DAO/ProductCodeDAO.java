/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import database.DAOException;
import java.sql.Connection;
import models.Product_Code;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;


/**
 *
 * @author admin
 */
public class ProductCodeDAO {

    protected  DataSource  myDataSource ;
 
    /*GetProductCodeByID(), GetAllProductCodes(),*/
    
    public ProductCodeDAO(DataSource myDataSource) {
        this.myDataSource = myDataSource;
    }
    
    
    public Product_Code GetProductCodeByID(String Prod_Code) throws DAOException {
            
        Product_Code pCode = new Product_Code();
		String sql = "SELECT * FROM PRODUCT_CODE WHERE Prod_Code = ? ";
		
	try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
			PreparedStatement stmt = connection.prepareStatement(sql)) {
                     
			stmt.setString(1, Prod_Code);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) { // On a trouvé
                                pCode.setProd_Code(Prod_Code);
                                pCode.setDiscount_code(rs.getString("DISCOUNT_CODE"));
                                pCode.setDescription(rs.getString("DESCRIPTION"));
				} 
                                
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}

		return pCode;
	} 
    
    
    
    public List<Product_Code> GetAllProductCodes() throws DAOException {
                List<Product_Code> LProduitsCode = new LinkedList<>();
		String sql = "SELECT * FROM PRODUCT_CODE ";
		
	try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
			PreparedStatement stmt = connection.prepareStatement(sql)) {
                       
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) { // On a trouvé
                                        Product_Code PCode = new Product_Code();
                                        PCode.setProd_Code(rs.getString("PROD_CODE"));
					PCode.setDiscount_code(rs.getString("DISCOUNT_CODE"));
                                        PCode.setDescription(rs.getString("DESCRIPTION"));
                                        LProduitsCode.add(PCode);
				
				} // else on n'a pas trouvé, on renverra null
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}

		return LProduitsCode;
	} 
    
    
    



}
