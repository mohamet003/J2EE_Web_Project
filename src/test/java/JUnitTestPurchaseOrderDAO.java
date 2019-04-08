/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.PurchaseOrderDAO;
import database.DAOException;
import database.Database;
import models.Product;
import java.util.LinkedList;
import java.util.List;
import models.Purchase_Order;
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
public class JUnitTestPurchaseOrderDAO {
    private PurchaseOrderDAO orderDAO;
    private int productID;
    private int orderNum;
    List <Purchase_Order> LOrder;
    int Quantity;
    
    public JUnitTestPurchaseOrderDAO() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        orderDAO = new PurchaseOrderDAO(Database.getDataSource());
        productID = 980001;
        orderNum = 10398001;
        Quantity =10;
           
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetPurchaseOrderByID() throws DAOException {  
      Purchase_Order order = orderDAO.GetPurchaseOrderByID(orderNum);
        assertEquals(productID,order.getProduct_ID());
    }
    
    @Test
    public void testGetPurchaseOrderByCustomer() throws DAOException {  
        LOrder = orderDAO.GetPurchaseOrderByCustomer(productID);
        assertNotEquals(0, LOrder.size());
    }
    
    /*@Test
    public void testAddPurchaseOrder() throws DAOException { 
        Purchase_Order order = new Purchase_Order();
        orderDAO.AddPurchaseOrder(order);
        L
        assertEquals(Quantity_on_hand, produit.getQuantity_on_hand());
    }*/
    
    @Test
    public void testUpdatePurchaseOrder() throws DAOException {  
        orderDAO.UpdatePurchaseOrder(orderNum, productID);
       Purchase_Order order = orderDAO.GetPurchaseOrderByID(orderNum);
       assertEquals(Quantity, order.getQuantity());
    }
    
    @Test
    public void testDeletePurchaseOrder() throws DAOException {  
        
       Purchase_Order order = orderDAO.GetPurchaseOrderByID(orderNum);
       orderDAO.DeletePurchaseOrder(orderNum);
       assertNull (order.getOrder_num());
    }
}
