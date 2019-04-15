/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.CACategorieDAO;
import database.DAOException;
import database.Database;
import java.text.ParseException;
import java.util.List;
import models.ShippingForCustomer;
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
public class JUnitTestCACategorie {
    private CACategorieDAO CACatDAO ;
    List<ShippingForCustomer> LShipping;
    String PRODUCT_CODE ="SW";
    String dateD = "2011-04-23";
    String dateF = "2019-04-23";
    
    public JUnitTestCACategorie() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        CACatDAO = new CACategorieDAO(Database.getDataSource());
    }
    
    @After
    public void tearDown() {
    }

    
     @Test
     public void TestGetCaByCategorie()throws DAOException, ParseException { 
         LShipping = (List<ShippingForCustomer>) CACatDAO.GetCaByCategorie(PRODUCT_CODE, dateD, dateF);
         assertNotEquals(0,LShipping.size());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
