/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.ProductDAO;
import database.DAOException;
import database.Database;
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
    
    public JUnitTestProductDAO() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pdao = new ProductDAO(Database.getDataSource());
        idProduct = 980005;
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
   
            
    
    @Test
    public void testGetProductById() throws DAOException {
        Product product = pdao.GetProductByID(idProduct);
        assertEquals("Accounting Application", product.getDescription());
    }
}
