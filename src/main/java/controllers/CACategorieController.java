/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.CACategorieDAO;
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
import models.ShippingForCustomer;

/**
 *
 * @author kevin
 */
@WebServlet(name = "CACategorieController", urlPatterns = {"/CACategorieController"})
public class CACategorieController extends HttpServlet {
    private String action = "";
    private String dateD = "";
    private String dateF = "";
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           action =  request.getParameter("id");
           dateD =  request.getParameter("dateD");
           dateF = request.getParameter("dateF");
           response.setContentType("application/json;charset=UTF-8");
           Properties resultat = new Properties();
           resultat.put("ca",CaForCategorie(action,dateD,dateF));
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
            Logger.getLogger(CACategorieController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CACategorieController.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<ShippingForCustomer> CaForCategorie(String PRODUCT_CODE,String dateD, String dateF) throws DAOException{
        
        try {   
            CACategorieDAO caU = new CACategorieDAO(Database.getDataSource());
            return caU.GetCaByCategorie(PRODUCT_CODE,dateD,dateF); 
        } catch (Exception e) {
            
        }
        return null;
        
    }
}
