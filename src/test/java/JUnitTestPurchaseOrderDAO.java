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
        productID = 980025;
        orderNum = 10398003;
        Quantity = 8;
        customer_ID= 2;
           
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
        assertNotEquals(0, LOrder.size());
    }
    
    @Test
    public void testGetPurchaseOrderByProduct() throws DAOException {  
       LOrder = orderDAO.GetPurchaseOrderByProduct(productID);
       assertNotEquals(0, LOrder.size());
    }
    
   @Test
    public void testAddPurchaseOrder() throws DAOException { 
        Purchase_Order order = new Purchase_Order();
        order.setCustomer_ID(customer_ID);
        order.setFreight_company("ISIS");
        order.setOrder_num(10398017);
        order.setProduct_ID(productID);
        order.setQuantity(5);
        order.setShipping_cost(650);
        orderDAO.AddPurchaseOrder(order);
        assertEquals(10398017, order.getOrder_num());
    }
    
    @Test
    public void testUpdatePurchaseOrder() throws DAOException {  
        orderDAO.UpdatePurchaseOrder(orderNum, 100);
       Purchase_Order order = orderDAO.GetPurchaseOrderByID(orderNum);
       assertEquals(100 , order.getQuantity());
    }
    
    @Test
    public void testDeletePurchaseOrder() throws DAOException {  
       orderDAO.DeletePurchaseOrder(10398017);
       Purchase_Order order = orderDAO.GetPurchaseOrderByID(10398017);
       assertEquals(0, order.getOrder_num());
    }
    
    
}
