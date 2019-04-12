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
import models.Micro_Market;

/**
 *
 * @author admin
 */
public class MicroMarketDAO {
    /*DAO: GetAllMicroMarkets(), GetMicroMarketByID*/
        protected  DataSource  myDataSource ;
        
        public MicroMarketDAO(DataSource myDataSource) {
        this.myDataSource = myDataSource;
    }
    public Micro_Market GetMicroMarketByID(int radius) throws DAOException {
            
        Micro_Market M = new Micro_Market();
		String sql = "SELECT * FROM MICRO_MARKET WHERE radius = ? ";
		
	try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
			PreparedStatement stmt = connection.prepareStatement(sql)) {
    
			stmt.setInt(1, radius);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) { // On a trouvé
                                M.setArea_length(rs.getInt("AREA_LENGTH"));
                                M.setArea_width(rs.getInt("AREA_WIDTH"));
				} 
                                
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}

		return M;
	} 
        
    
    
    
    public List<Micro_Market> GetAllMicroMarkets() throws DAOException {
                List<Micro_Market> LMicroMarkets = new LinkedList<>();
		String sql = "SELECT * FROM MICRO_MARKET ";
		
	try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
			PreparedStatement stmt = connection.prepareStatement(sql)) {
                       
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) { // On a trouvé
                                        Micro_Market MM = new Micro_Market();
                                        MM.setZip(rs.getInt("ZIP_CODE"));
					MM.setArea_length(rs.getInt("AREA_LENGTH"));
                                        MM.setArea_width(rs.getInt("AREA_WIDTH"));
                                        LMicroMarkets.add(MM);
		
				} // else on n'a pas trouvé, on renverra null
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}

		return LMicroMarkets;
	} 
    
    
    

}
