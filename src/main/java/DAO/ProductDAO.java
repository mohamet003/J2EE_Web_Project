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
import models.Product;

/**
 *
 * @author KAMDOM Merveille
 */
public class ProductDAO {

    protected DataSource myDataSource;

    public ProductDAO(DataSource myDataSource) {
        this.myDataSource = myDataSource;
    }

    public ProductDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Product> GetAllProduct() throws DAOException {
        List<Product> LProduits = new LinkedList<>();
        String sql = "SELECT PRODUCT_ID,MANUFACTURER_ID,PRODUCT_CODE,PURCHASE_COST,QUANTITY_ON_HAND,MARKUP,AVAILABLE,PRODUCT.DESCRIPTION,RATE \n"
                + "FROM PRODUCT INNER JOIN PRODUCT_CODE ON (PRODUCT_CODE = PROD_CODE) INNER JOIN DISCOUNT_CODE ON DISCOUNT_CODE.DISCOUNT_CODE = PRODUCT_CODE.DISCOUNT_CODE\n";

        try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Product P = new Product();
                    P.setProduct_ID(rs.getInt("PRODUCT_ID"));
                    P.setPurchase_cost(rs.getInt("PURCHASE_COST"));
                    P.setProduct_code(rs.getString("PRODUCT_CODE"));
                    P.setPurchase_cost(rs.getFloat("PURCHASE_COST"));
                    P.setQuantity_on_hand(rs.getInt("QUANTITY_ON_HAND"));
                    P.setMarkup(rs.getFloat("MARKUP"));
                    P.setAvailable(rs.getBoolean("AVAILABLE"));
                    P.setDescription(rs.getString("DESCRIPTION"));
                    P.setRate(rs.getFloat("RATE"));
                    LProduits.add(P);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getMessage());
        }

        return LProduits;
    }

    public Product GetProductByID(int product_ID) throws DAOException {

        Product p = new Product();
        String sql = "SELECT PRODUCT_ID,MANUFACTURER_ID,PRODUCT_CODE,PURCHASE_COST,QUANTITY_ON_HAND,MARKUP,AVAILABLE,PRODUCT.DESCRIPTION,RATE \n"
                + "FROM PRODUCT INNER JOIN PRODUCT_CODE ON (PRODUCT_CODE = PROD_CODE) INNER JOIN DISCOUNT_CODE "
                + "ON DISCOUNT_CODE.DISCOUNT_CODE = PRODUCT_CODE.DISCOUNT_CODE WHERE PRODUCT.PRODUCT_ID =?\n " ;

        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, product_ID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    p.setAvailable(rs.getBoolean("AVAILABLE"));
                    p.setDescription(rs.getString("DESCRIPTION"));
                    p.setManufacturer_ID(rs.getInt("MANUFACTURER_ID"));
                    p.setMarkup(rs.getFloat("MARKUP"));
                    p.setProduct_ID(product_ID);
                    p.setProduct_code(rs.getString("PRODUCT_CODE"));
                    p.setPurchase_cost(rs.getFloat("PURCHASE_COST"));
                    p.setQuantity_on_hand(rs.getInt("QUANTITY_ON_HAND"));
                    p.setRate(rs.getFloat("RATE"));
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getMessage());
        }

        return p;
    }


    public int LastInsertID() throws DAOException {

        String sql = "SELECT MAX(ORDER_NUM) as num FROM PURCHASE_ORDER" ;
        int num = 0;
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    num = rs.getInt("num");
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getMessage());
        }

        return num;
    }


    public List<Product> GetAllProductsByProductCode(String product_code) throws DAOException {

        List<Product> LProduits = new LinkedList<>();

        String sql = "SELECT PRODUCT_ID,MANUFACTURER_ID,PRODUCT_CODE,PURCHASE_COST,QUANTITY_ON_HAND,MARKUP,AVAILABLE,PRODUCT.DESCRIPTION,RATE \n"
                + "FROM PRODUCT INNER JOIN PRODUCT_CODE ON (PRODUCT_CODE = PROD_CODE) INNER JOIN DISCOUNT_CODE "
                + "ON DISCOUNT_CODE.DISCOUNT_CODE = PRODUCT_CODE.DISCOUNT_CODE WHERE PRODUCT.PRODUCT_CODE =?\n ";

        try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, product_code);
            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Product p = new Product();
                    p.setAvailable(rs.getBoolean("AVAILABLE"));
                    p.setDescription(rs.getString("DESCRIPTION"));
                    p.setManufacturer_ID(rs.getInt("MANUFACTURER_ID"));
                    p.setMarkup(rs.getFloat("MARKUP"));
                    p.setProduct_ID(rs.getInt("PRODUCT_ID"));
                    p.setPurchase_cost(rs.getFloat("PURCHASE_COST"));
                    p.setProduct_code(rs.getString("PRODUCT_CODE"));
                    p.setQuantity_on_hand(rs.getInt("QUANTITY_ON_HAND"));
                    p.setRate(rs.getFloat("RATE"));
                    LProduits.add(p);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getMessage());
        }

        return LProduits;
    }

    public void UpdateProduct(int product_ID, int Quantity_on_hand) throws DAOException {
        String sql = "UPDATE PRODUCT SET QUANTITY_ON_HAND = ? WHERE PRODUCT_ID = ? ";

        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, Quantity_on_hand);
            stmt.setInt(2, product_ID);
            int rs = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getMessage());
        }
    }

    public List<Product> FindProduct(String nom) throws DAOException {

        String sql = "SELECT PRODUCT_ID,MANUFACTURER_ID,PRODUCT_CODE,PURCHASE_COST,QUANTITY_ON_HAND,MARKUP,AVAILABLE,PRODUCT.DESCRIPTION,RATE \n"
                + "FROM PRODUCT INNER JOIN PRODUCT_CODE ON (PRODUCT_CODE = PROD_CODE) INNER JOIN DISCOUNT_CODE ON DISCOUNT_CODE.DISCOUNT_CODE = PRODUCT_CODE.DISCOUNT_CODE\n"
                + "WHERE lower (PRODUCT.DESCRIPTION) LIKE ?\n";

        List<Product> LProduits = new LinkedList();
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nom);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Product P = new Product();
                    P.setProduct_ID(rs.getInt("PRODUCT_ID"));
                    P.setPurchase_cost(rs.getInt("PURCHASE_COST"));
                    P.setProduct_code(rs.getString("PRODUCT_CODE"));
                    P.setPurchase_cost(rs.getFloat("PURCHASE_COST"));
                    P.setQuantity_on_hand(rs.getInt("QUANTITY_ON_HAND"));
                    P.setMarkup(rs.getFloat("MARKUP"));
                    P.setAvailable(rs.getBoolean("AVAILABLE"));
                    P.setDescription(rs.getString("DESCRIPTION"));
                    P.setRate(rs.getFloat("RATE"));
                    LProduits.add(P);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getMessage());
        }
        return LProduits;
    }
    
   
}
