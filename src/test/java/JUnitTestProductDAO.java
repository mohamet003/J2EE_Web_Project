/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.ProductDAO;
import database.DAOException;
import database.Database;
import java.util.List;
import models.Product;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mohametkone
 */
public class JUnitTestProductDAO {
    
    private ProductDAO pdao;
    int idProduct;
    List<Product> LProduct;
    String product_code;
    int quantity_on_hand;
    Product product;
    
    public JUnitTestProductDAO() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws DAOException {
        pdao = new ProductDAO(Database.getDataSource());
        idProduct = 980005;
        product_code = "SW";
        quantity_on_hand= 13;
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllProduct() throws DAOException {
        LProduct = (List<Product>) pdao.GetAllProduct();
        assertNotEquals(0,LProduct.size());
    }
    
    @Test
    public void testGetProductById() throws DAOException {
        Product produit = pdao.GetProductByID(idProduct);
        assertEquals("Accounting Application", produit.getDescription());
    }
    
    @Test
    public void testGetAllProductsByProductCode() throws DAOException {
        LProduct = pdao.GetAllProductsByProductCode(product_code);
        assertNotEquals(0,LProduct.size());
    }
    
    /**
     *
     * @throws DAOException
     */
    @Test
    public void testUpdateProduct() throws DAOException {
        pdao.UpdateProduct(idProduct, quantity_on_hand); 
        product = pdao.GetProductByID(idProduct);
        assertEquals(13,product.getQuantity_on_hand());
    }
}
