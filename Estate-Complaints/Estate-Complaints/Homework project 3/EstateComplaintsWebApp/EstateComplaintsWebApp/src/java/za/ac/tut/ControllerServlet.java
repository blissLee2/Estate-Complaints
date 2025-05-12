/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut;

import bl.AdminFacadeLocal;
import bl.ResidentFacadeLocal;
import bl.UserFacadeLocal;
import entities.Admin;
import entities.Complaint;
import entities.Resident;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author General_user
 */
public class ControllerServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
    }

   
    @EJB private ResidentFacadeLocal rfl;
    @EJB private AdminFacadeLocal afl;
    @EJB private UserFacadeLocal ufl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           String operation = request.getParameter("operation");
           String url = "";
           if(operation.equalsIgnoreCase("register")){
             String estateName = request.getParameter("estateName");
             String name = request.getParameter("name");
             String email = request.getParameter("email");
             String password = request.getParameter("password");
             Long id = Long.parseLong(request.getParameter("id"));
              url = "index.html";
             
             if(request.getParameter("regType").equalsIgnoreCase("resident")){
             Integer unitNumber =Integer.parseInt(request.getParameter("unitNumber"));
             Resident r = new Resident();
            List<Complaint> complaints = new ArrayList<>();
             r.setId(id);
             r.setEmailAddress(email);
             r.setName(name);
             r.setPassword(password);
             r.setUnitNumber(unitNumber);
             r.setComplaints(complaints);
             rfl.create(r);
             url = "index.html";
             }else{
             List<String> announcements = new ArrayList<>();
             
             Admin a = new Admin();
            List<Complaint> complaints = new ArrayList<>();
             a.setId(id);
             a.setEmailAddress(email);
             a.setName(name);
             a.setPassword(password);
             a.setAnnouncements(announcements);
            
             afl.create(a);
             }
           
           }else if(operation.equalsIgnoreCase("login")){
           Long id = Long.parseLong(request.getParameter("id"));
           String password = request.getParameter("password");
           User user = ufl.find(id);
           if(user.getPassword().equals(password)){
               HttpSession s = request.getSession(true);
               s.setAttribute("user", user);
               url = getRequiredUrl(user);
           
           }else{
           url = "login.jsp";
           request.setAttribute("message", "Incorrect Email or Password");
           }
           }

RequestDispatcher rd = request.getRequestDispatcher(url);
rd.forward(request, response);
//processRequest(request, response);
    }

    private String getRequiredUrl(User u){
    String url = "";
    if(u instanceof Admin){
    url ="admin_main_page.jsp";
    }else{
    url ="resident_main_page.jsp";
    }
    
    return url;
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

}
