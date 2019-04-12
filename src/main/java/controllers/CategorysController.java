/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import DAO.ProductCodeDAO;
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
import models.Product_Code;

/**
 *
 * @author mohametkone
 */
@WebServlet(name="CategorysController", urlPatterns={"/CategorysController"})
public class CategorysController extends HttpServlet {
    ProductCodeDAO daop = new ProductCodeDAO(Database.getDataSource());
    Properties resultat = new Properties();
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, DAOException {

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            // Si l'utilisateur n'est plus  connecté, on le renvoie à la page de connexion 
            if (this.findUserInSession(request) == null) {
                System.out.println("On redirige vers la connexion");
                response.setContentType("text/html;charset=UTF-8");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }


            response.setContentType("application/json;charset=UTF-8");
            List<Product_Code> categorys = daop.GetAllProductCodes();
            resultat.put("categorys",categorys);
            // Générer du JSON
            Gson gson = new Gson();
            out.println(gson.toJson(resultat)); 
            
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
            Logger.getLogger(CategorysController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
            Logger.getLogger(CategorysController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

        // trouver l'utilisateur connecté 
    public CustomerEntity findUserInSession(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        return (session == null) ? null : (CustomerEntity) session.getAttribute("user");
    }
}
