/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.ProductCodeDAO;
import database.DAOException;
import database.Database;
import java.util.List;
import models.Product_Code;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class JUnitTestProductCodeDAO {
    
    private ProductCodeDAO PCDAO;
        List<Product_Code> LProduitsCode ;
        String Prod_Code;
        String discount_code;
        String description;
        
    
    public JUnitTestProductCodeDAO() {
    
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        PCDAO= new ProductCodeDAO(Database.getDataSource());
        Prod_Code =  "SW" ;
        discount_code = "M";
        description =  "Software";
    }
    
    @After
    public void tearDown() {
    }
 
    @Test
    public void TestGetProductCodeByID() throws DAOException { 
         Product_Code ProduitCode = PCDAO.GetProductCodeByID(Prod_Code);
         assertEquals("Software", ProduitCode.getDescription());
    }
    
    
    @Test
    public void TestGetAllProductCodes() throws DAOException { 
         LProduitsCode = (List<Product_Code>) PCDAO.GetAllProductCodes();
         assertNotEquals(0,LProduitsCode.size());
    }
}
