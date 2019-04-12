
import DAO.CACategorieDAO;
import DAO.CAZoneGeographiqueDAO;
import DAO.DiscountDAO;
import DAO.CustomerDAO;
import DAO.ProductCodeDAO;
import database.DAOException;
import database.Database;
import javax.sql.DataSource;
import models.CustomerEntity;
import models.Purchase_Order;
import DAO.ProductDAO;
import DAO.PurchaseOrderDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import jdk.nashorn.internal.parser.JSONParser;
import models.Product;
import DAO.DiscountDAO;
import DAO.ShippingCustomerDAO;
import java.text.ParseException;
import models.ShippingForCustomer;

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

    public static void main(String[] args) throws DAOException, ParseException {
        // TODO code application logic here

        /*

        PurchaseOrderDAO dao = new PurchaseOrderDAO(Database.getDataSource());
        dao.DeletePurchaseOrder(5);
        
        /*order.setCustomer_ID(3);
        order.setProduct_ID(986710);
        order.setFreight_company("IISISIS");
        order.setQuantity(230);
        order.setShipping_cost(2300);
        order.setOrder_num(5);
      
        dao.AddPurchaseOrder(order);
        
     
        CustomerDAO dao = new CustomerDAO(Database.getDataSource());
        CustomerEntity cust =  dao.findCustomer(2);
        System.out.println("test"+cust.getName()); */
      
      /*   
        DiscountDAO dDAO = new DiscountDAO (Database.getDataSource());
        Discount_Code d = dDAO.GetDiscountByID('H');
        System.out.println("resulat"+ d.getRate());


   */  
      //Date date = Calendar.getInstance().getTime();
      

        
        PurchaseOrderDAO dao = new PurchaseOrderDAO(Database.getDataSource());
        Purchase_Order order = new Purchase_Order();
        
        order.setCustomer_ID(3);
        order.setProduct_ID(986710);
        order.setFreight_company("IISISIS");
        order.setQuantity(230);
  
        order.setShipping_cost(2300);
        order.setOrder_num(62);
        
        //dao.DeletePurchaseOrder(62);
        
        ProductCodeDAO codeDAO = new ProductCodeDAO(Database.getDataSource());
        
        System.out.println("NN "+codeDAO.GetAllProductCodes().size());
      
        //dao.AddPurchaseOrder(order);
        //Purchase_Order order2 = dao.GetPurchaseOrderByID(10398001);
        
        //System.out.println("pol "+order);

        DiscountDAO ddao = new DiscountDAO(Database.getDataSource());

        float rate = ddao.GetDiscountByID("M").getRate();
        System.out.println("rate  "+rate);

        CACategorieDAO cacdao = new CACategorieDAO(Database.getDataSource());
        List<ShippingForCustomer> lca = cacdao.GetCaByCategorie("HW", "2011-05-24", "2019-04-11");
        
        for (ShippingForCustomer shippingForCustomer : lca) {
            System.out.println("Ressss "+shippingForCustomer.getCA()+"   dddada  "+shippingForCustomer.getDate());
        }
        
        ShippingCustomerDAO scdao = new ShippingCustomerDAO(Database.getDataSource());
        List<ShippingForCustomer> li = scdao.GetCaByIDCustomer(1, "2011-05-24", "2019-04-11");
        
        for (ShippingForCustomer shippingForCustomer : li) {
            System.out.println("res "+shippingForCustomer.getDate()+"  ca "+shippingForCustomer.getCA());
        }
        
        
        CAZoneGeographiqueDAO cazgdao = new CAZoneGeographiqueDAO(Database.getDataSource());
        List<ShippingForCustomer> customers = cazgdao.GetCaByZoneGeo("FL", "2011-05-24", "2019-04-11");
        
        for (ShippingForCustomer customer : customers) {
            System.out.println("data  "+customer.getDate()+"   ca "+customer.getCA());
        }
        
        //System.out.println("test"+cust.getName()); 
    }
   
}
