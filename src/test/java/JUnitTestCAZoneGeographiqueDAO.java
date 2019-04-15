/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.CAZoneGeographiqueDAO;
import database.DAOException;
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
public class JUnitTestCAZoneGeographiqueDAO {
    
    private CAZoneGeographiqueDAO CAZGDAO ;
    List<ShippingForCustomer> LShipping;
    String zone ="95051";
    String dateD = "2011-04-23";
    String dateF = "2019-04-23";
    
    public JUnitTestCAZoneGeographiqueDAO() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    @Test
     public void TestGetCaByZoneGeo()throws DAOException, ParseException{ 
         LShipping = (List<ShippingForCustomer>) CAZGDAO.GetCaByZoneGeo(zone, dateD, dateF);
         assertNotEquals(0,LShipping.size());
    }
}
