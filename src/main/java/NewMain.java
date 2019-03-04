
import DAO.DiscountDAO;
import DAO.PurchaseOrderDAO;
import DAO.TestDAO;
import database.DAOException;
import database.Database;
import javax.sql.DataSource;
import models.CustomerEntity;
import models.Purchase_Order;
import DAO.ProductDAO;
import java.util.LinkedList;
import java.util.List;
import jdk.nashorn.internal.parser.JSONParser;
import models.Discount_Code;
import models.Product;


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
        
     
        /*TestDAO dao = new TestDAO(Database.getDataSource());
        CustomerEntity cust =  dao.findCustomer(2);
        System.out.println("test"+cust.getName());*/
      
        DiscountDAO dDAO = new DiscountDAO (Database.getDataSource());
        Discount_Code d = dDAO.GetDiscountByID('H');
        System.out.println("resulat"+ d.getRate());

        
    }
   
}
