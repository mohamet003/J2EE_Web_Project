/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import DAO.TestDAO;
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

/**
 *
 * @author mohametkone
 */
@WebServlet(name="LoginController", urlPatterns={"/LoginController"})
public class LoginController extends HttpServlet {
    TestDAO dao = new TestDAO(Database.getDataSource());
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
           

       try {
            action = request.getParameter("connexion");
            email = request.getParameter("email");
            pwd = Integer.parseInt(request.getParameter("password"));
            
           } catch (Exception e) {
            if (email != null){
                request.setAttribute("result","error");
            }
            
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
            switch (action){
                
                case "connexion":
                        if (connexion(email, pwd ,request)) {
                         CustomerEntity customerEntity = this.findUserInSession(request);
                         request.setAttribute("user",customerEntity);	
                         request.getRequestDispatcher("client/index.jsp").forward(request, response);
                    }else{                         
                        request.setAttribute("result","error");
                        }
                    break;
                case "deconnexion":
                        if (deconnexion(request)) {	
                         request.getRequestDispatcher("login.jsp").forward(request,response);
                    }
                    break;
            }            

        request.getRequestDispatcher("login.jsp").forward(request, response);
    } 
	// On continue vers la page JSP sélectionnée
	//request.getRequestDispatcher("index.jsp").forward(request, response);

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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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


    public boolean connexion(String email, int ID, HttpServletRequest request) throws DAOException{
        
        try {
            CustomerEntity customerEntity = this.dao.findCustomerByLoginAndPwd(ID, email);

	HttpSession session = request.getSession(true); // démarre la session
	session.setAttribute("user", customerEntity);
        
        return customerEntity != null; 
        } catch (Exception e) {
            
        }
        return false;

    }

    public boolean deconnexion(HttpServletRequest request) throws DAOException{
        
        try {
           

            HttpSession session = request.getSession(false); // démarre la session

            if (session != null) session.invalidate();
            return true;
	
        } catch (Exception e) {
            
        }
return false;

    }
    
    public CustomerEntity findUserInSession(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		return (session == null) ? null : (CustomerEntity) session.getAttribute("user");
	}

}
