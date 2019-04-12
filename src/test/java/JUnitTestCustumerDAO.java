/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.CustomerDAO;
import database.DAOException;
import database.Database;
import models.CustomerEntity;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mohametkone
 */
public class JUnitTestCustumerDAO {
    
    private CustomerDAO cdao;
    int id;
    String email;
    
    public JUnitTestCustumerDAO() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
                
        cdao = new CustomerDAO(Database.getDataSource());
        id = 1;
        email = "jumboeagle@example.com";
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
     @Test
     public void TestfindCustomerByLoginAndPwd() throws DAOException {
     
         CustomerEntity user = cdao.findCustomerByLoginAndPwd(id, email);
         assertEquals("Jumbo Eagle Corp", user.getName());
     }
    
     @Test
     public void TestfindCustomer() throws DAOException {
     
         CustomerEntity user = cdao.findCustomer(id);
         assertEquals("Jumbo Eagle Corp",user.getName());
     }
     
     @Test
     public void TestfindAllCustomer()throws DAOException {
     
         CustomerEntity user = (CustomerEntity) cdao.findAllCustomer();
         assertEquals("Jumbo Eagle Corp", user.getName());
     }
     
     

}