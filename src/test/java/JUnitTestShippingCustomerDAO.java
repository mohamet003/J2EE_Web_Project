/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.ShippingCustomerDAO;
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
public class JUnitTestShippingCustomerDAO {
    
    
    private ShippingCustomerDAO SCDAO ;
    List<ShippingForCustomer> LShipping;
    String dateD = "2011-04-23";
    String dateF = "2019-04-23";
    int customerID=1;
    
    public JUnitTestShippingCustomerDAO() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        SCDAO= new ShippingCustomerDAO  (Database.getDataSource());
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
     public void TestGetCaByIDCustomer()throws DAOException, ParseException{ 
         LShipping = (List<ShippingForCustomer>) SCDAO.GetCaByIDCustomer(customerID, dateD, dateF);
         assertNotEquals(0,LShipping.size());
    }
    // @Test
    
    // public void hello() {}
}
