/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.ProductDAO;
import DAO.PurchaseOrderDAO;
import com.google.gson.Gson;
import database.DAOException;
import database.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.CustomerEntity;
import models.Product;
import models.Purchase_Order;

/**
 *
 * @author mohametkone
 */
@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {

    PurchaseOrderDAO purcharseOrderDAO = new PurchaseOrderDAO(Database.getDataSource());
    ProductDAO daop = new ProductDAO(Database.getDataSource());

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOException {
            
            List<Purchase_Order> lorders =  null;
            CustomerEntity curentUser = null;

        try ( PrintWriter out = response.getWriter()) {
            // Si l'utilisateur n'est plus  connecté, on le renvoie vers la page de connexion 
            if (this.findUserInSession(request) == null) {
                System.out.println("On redirige vers la connexion");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }else{

            // On récupére l'utilisateur courant et ses commandes
            curentUser = findUserInSession(request);
            lorders = purcharseOrderDAO.GetPurchaseOrderByCustomer(curentUser.getCustomerId());

            }



            String action = "";
            int id = 0;
            int qte = 0;

            if (request.getParameter("target") != null) {

                action = request.getParameter("target");
                System.out.println(action);

                switch (action) {

                    case "addorder":

                        id = Integer.parseInt(request.getParameter("idProduct"));
                        float frais = Float.parseFloat(request.getParameter("frais"));
                        qte = Integer.parseInt(request.getParameter("qte"));
                        Product p = daop.GetProductByID(id);
                        Purchase_Order order = new Purchase_Order();
                        order.setCustomer_ID(curentUser.getCustomerId());
                        order.setProduct_ID(id);
                        order.setQuantity(qte);
                        order.setFreight_company("ISIS");
                        order.setShipping_cost(frais);
                        order.setOrder_num(id + 10 * 3);
                        purcharseOrderDAO.AddPurchaseOrder(order);
                        break;

                    case "updateorder":

                        id = Integer.parseInt(request.getParameter("idOrder"));
                        qte = Integer.parseInt(request.getParameter("qte"));
                        System.out.println(id+" ---------------  "+qte);
                        purcharseOrderDAO.UpdatePurchaseOrder(id , qte);
                        break;

                    case "deleteorder":

                        id = Integer.parseInt(request.getParameter("idOrder"));
                        purcharseOrderDAO.DeletePurchaseOrder(id);
                        break;
                }

            }

            if (lorders != null){

                response.setContentType("application/json;charset=UTF-8");
                Properties resultat = new Properties();
                // On récupére les commandes de l'utilisateur courant 
                resultat.put("orders", lorders);
                // Générer du JSON
                Gson gson = new Gson();
                out.println(gson.toJson(resultat));
            }


        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DAOException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DAOException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public CustomerEntity findUserInSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session == null) ? null : (CustomerEntity) session.getAttribute("user");
    }

}
