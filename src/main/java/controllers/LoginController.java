/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.CustomerDAO;
import DAO.ProductCodeDAO;
import database.DAOException;
import database.Database;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.CustomerEntity;
import javax.servlet.http.HttpSession;
import models.Product_Code;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author mohametkone
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    CustomerDAO dao = new CustomerDAO(Database.getDataSource());
    ProductCodeDAO daop = new ProductCodeDAO(Database.getDataSource());

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws database.DAOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOException {
        response.setContentType("text/html;charset=UTF-8");

        String email = "";
        int pwd = 0;
        String action = "";
        String adminLog = "admin@admin.com";
        int adminPwd = 123;

        // je recupere l'ensemble des catégories
        List<Product_Code> categorys = daop.GetAllProductCodes();
        request.setAttribute("categorys", categorys);

        if (request.getParameter("connexion") != null) {

            try {
                action = request.getParameter("connexion");
                email = request.getParameter("email");
                pwd = Integer.parseInt(request.getParameter("password"));

            } catch (Exception e) {
                if (email != null) {
                    request.setAttribute("result", "error");
                }
            }
        }else{

            if (this.findUserInSession(request) != null){
                request.getRequestDispatcher("client/index.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            
        }

        switch (action) {

            case "connexion":
                if (email == adminLog || pwd == adminPwd) {
                    if (connexion(email, pwd, request)) {
                        CustomerEntity customerEntity = this.findUserInSession(request);
                        request.setAttribute("user", customerEntity);
                        request.getRequestDispatcher("Admin/index.jsp").forward(request, response);
                    }
                    else{
                        request.setAttribute("result", "error");
                    }
                } else {
                    if (connexion(email, pwd, request)) {
                        CustomerEntity customerEntity = this.findUserInSession(request);
                        request.setAttribute("user", customerEntity);
                        request.getRequestDispatcher("client/index.jsp").forward(request, response);
                    } else {
                        request.setAttribute("result", "error");
                    }
                }
                break;
            case "deconnexion":
                if (deconnexion(request)) {
 System.out.println("deconnexion");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
                break;
        }
        //request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    // On continue vers la page JSP sélectionnée
    //request.getRequestDispatcher("index.jsp").forward(request, response);

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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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

    // creer une session pour l'utilisateur
    public boolean connexion(String email, int ID, HttpServletRequest request) throws DAOException {

        try {
                CustomerEntity customerEntity = new CustomerEntity();
            if((email == "admin@admin.com") || (ID == 123)){
                customerEntity.setCustomerId(ID);
                customerEntity.setEmail(email);
                HttpSession session = request.getSession(true); // démarre la session
                session.setAttribute("user", customerEntity);
            }
            else{
                customerEntity = this.dao.findCustomerByLoginAndPwd(ID, email);

                 HttpSession session = request.getSession(true); // démarre la session
                 session.setAttribute("user", customerEntity);
            
            }

            return customerEntity != null;
        } catch (Exception e) {

        }
        return false;

    }

    // detruire la session pour l'utilisateur
    public boolean deconnexion(HttpServletRequest request) throws DAOException {

        try {

            HttpSession session = request.getSession(false); // fermer la session

            if (session != null) {
                session.invalidate();
            }
            return true;

        } catch (Exception e) {

        }
        return false;

    }

    // trouver l'utilisateur connecté 
    public CustomerEntity findUserInSession(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        return (session == null) ? null : (CustomerEntity) session.getAttribute("user");
    }

}
