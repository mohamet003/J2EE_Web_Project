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
    int customer_ID;
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
        orderNum = 30198001;
        Quantity =10;
        customer_ID= 409;
           
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
        LOrder = orderDAO.GetPurchaseOrderByCustomer(customer_ID);
        assertEquals(1, LOrder.size());
    }
    
    @Test
    public void testGetPurchaseOrderByProduct() throws DAOException {  
       LOrder = orderDAO.GetPurchaseOrderByProduct(productID);
       assertNotEquals(0, LOrder.size());
    }
    
    /*@Test
    public void testAddPurchaseOrder() throws DAOException { 
        Purchase_Order order = new Purchase_Order();
        LOrder.add(orderDAO.AddPurchaseOrder(order));
        assertEquals(Quantity_on_hand, produit.getQuantity_on_hand());
    }*/
    
    @Test
    public void testUpdatePurchaseOrder() throws DAOException {  
        orderDAO.UpdatePurchaseOrder(orderNum, 100);
       Purchase_Order order = orderDAO.GetPurchaseOrderByID(orderNum);
       assertEquals(100 , order.getQuantity());
    }
    
    @Test
    public void testDeletePurchaseOrder() throws DAOException {  
       orderDAO.DeletePurchaseOrder(orderNum);
       Purchase_Order order = orderDAO.GetPurchaseOrderByID(orderNum);
       assertNull (order.getOrder_num());
    }
    
    
}
