/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.MicroMarketDAO;
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
public class JUnitTestMicroMarketDAO {
    
    private MicroMarketDAO MMDAO;
    int radius;
    int area_length;
    int area_width;
     
    public JUnitTestMicroMarketDAO() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        /*MMDAO= new MicroMarketDAO(Database.getDataSource());
        radius =;????????
        area_length =;???????
        area_length = ;*/
    }
    
    @After
    public void tearDown() {
    }

    
    /*@Test
    public void TestGetMicroMarketByID() throws DAOException { 
         Micro_Market user = MMDAO.GetMicroMarketByID(radius);
         assertEquals("// ???", user.getName()); ????????
     }
     @Test
    public void TestGetAllMicroMarkets() throws DAOException { 
         Micro_Market user = MMDAO.GetAllMicroMarkets();
         assertEquals("// ???", user.getName()); ????????
    
    */
}
