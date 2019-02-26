
import DAO.PurchaseOrderDAO;
import DAO.TestDAO;
import database.DAOException;
import database.Database;
import javax.sql.DataSource;
import models.CustomerEntity;
import models.Purchase_Order;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohamet Kone
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws DAOException {
        // TODO code application logic here
        
     
        TestDAO dao = new TestDAO(Database.getDataSource());
        CustomerEntity cust =  dao.findCustomer(2);
        System.out.println("test  "+cust.getName());
       
        PurchaseOrderDAO achatDAO = new PurchaseOrderDAO(Database.getDataSource());
        Purchase_Order order = achatDAO.GetPurchaseOrderByID(10398001);
        System.out.println(order);
    }
    
    
}
