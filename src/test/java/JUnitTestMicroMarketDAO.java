/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.MicroMarketDAO;
import database.DAOException;
import database.Database;
import java.util.List;
import models.Micro_Market;
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
        List<Micro_Market> LMicroMarkets; 
        int zip_Code;
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
        MMDAO= new MicroMarketDAO(Database.getDataSource());
        zip_Code = 95051;
        radius =(int) 255.59;
        area_length = (int) 689.856;
        area_width = (int) 478.479;
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void TestGetMicroMarketByID() throws DAOException { 
         Micro_Market  MM = MMDAO.GetMicroMarketByID(zip_Code);
         assertEquals("255.59", MM.getRadius());
     }
  
    @Test
    public void TestGetAllMicroMarkets() throws DAOException { 
        LMicroMarkets =  (List<Micro_Market>)MMDAO.GetAllMicroMarkets();
         assertNotEquals(0,LMicroMarkets.size());
    
    }
}
