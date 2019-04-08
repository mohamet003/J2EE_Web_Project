/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.DiscountDAO;
import database.DAOException;
//import models.Discount_Code;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author KAMDOM Merveille
 */
public class JUnitTestDiscountDAO {
    private DiscountDAO Ddao;
    private char DCode ;
    public JUnitTestDiscountDAO() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
     DCode = 'H';   
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetDiscountByID() throws DAOException {
    /*    Discount_Code DCode = Ddao.GetDiscountByID(DCode);
        assertEquals("Accounting Application", product.getDescription());*/
    }
}
