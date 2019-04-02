/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.ProductDAO;
import com.google.gson.Gson;
import database.DAOException;
import database.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;

/**
 *
 * @author mohametkone
 */
@WebServlet(name = "ProductController", urlPatterns = {"/ProductController"})
public class ProductController extends HttpServlet {
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
        
        try ( PrintWriter out = response.getWriter()) {
          
   
            response.setContentType("application/json;charset=UTF-8");
            Properties resultat = new Properties();

            resultat.put("products",productOrganize(daop.GetAllProduct()));

            // Générer du JSON
            Gson gson = new Gson();
            out.println(gson.toJson(resultat));

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
             Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
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
             Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
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

    
        public List<List<Product>>  productOrganize(List<Product> Lproducts){
        
            List<List<Product>> products = new  LinkedList<>();
            int cpt = 0;
            List<Product> By4products = new  LinkedList<>();
            
            for (Product p : Lproducts){
              
                if (cpt == 4) {
                    cpt = 0;
                    By4products = new  LinkedList<>();
                    products.add(By4products);
                }
                cpt++;
                By4products.add(p);   
                

            }
            
            return products;
    }
        
                
        

}
