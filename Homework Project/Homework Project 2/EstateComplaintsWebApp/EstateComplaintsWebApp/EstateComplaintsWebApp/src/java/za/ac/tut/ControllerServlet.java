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
import entities.Estate;
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
             String address = "";
             String name = request.getParameter("name");
             String email = request.getParameter("email");
             String password = request.getParameter("password");
             Long id = Long.parseLong(request.getParameter("id"));
             
             if(request.getParameter("regType").equalsIgnoreCase("resident")){
             Integer unitNumber =Integer.parseInt(request.getParameter("unitNumber"));
             Resident r = new Resident();
            List<Complaint> complaints = new ArrayList<>();
             r.setId(id);
             r.setEmailAddress(email);
             r.setName(name);
             r.setPassword(password);
             r.setEstate(new Estate(address,estateName));
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
             a.setEstate(new Estate("",estateName));
            
             afl.create(a);
             url = "index.html";
             }
           
           }else if(operation.equalsIgnoreCase("login")){
           Long id = Long.parseLong(request.getParameter("id"));
           String password = request.getParameter("password");
           User user = ufl.find(id);
           if(user!=null && user.getPassword().equals(password)){
               HttpSession s = request.getSession(true);
               s.setAttribute("user", user);
               s.setAttribute("paste", false);
               url = getRequiredUrl(user);
           
           }else{
           url = "login.jsp";
           request.setAttribute("message", "Incorrect Email or Password");
           }
           }
           else if(operation.equalsIgnoreCase("announce")){
           String announcement = request.getParameter("announcement");
           HttpSession s = request.getSession();
           User u =(User) s.getAttribute("user");
           Admin a = (Admin) u;
           a.getAnnouncements().add(announcement);
           afl.edit(a);
           url = "admin_main_page.jsp";
           }else if(operation.equalsIgnoreCase("complain")){
           String problemType = request.getParameter("problemType");
           String description = request.getParameter("description");
           HttpSession s = request.getSession();
           User u =(User) s.getAttribute("user");
           Resident r = (Resident) u;
           r.getComplaints().add(new Complaint(problemType,description));
           rfl.edit(r);
           url = "resident_main_page.jsp";
           }
           else if(operation.equalsIgnoreCase("view_complain")){
            HttpSession s = request.getSession();
            User u = (User) s.getAttribute("user");
            Admin a = (Admin)u;
            String estateName=a.getEstate().getEstateName();
           List<Resident> residents = rfl.findInEst(estateName);
           request.setAttribute("residents", residents);
           url = "viewComplaints.jsp";
           }
           else if(operation.equalsIgnoreCase("view_Announcements")){
            HttpSession s = request.getSession();
            request.setAttribute("paste", true);
            User u = (User) s.getAttribute("user");
            Resident r = (Resident)u;
            String estateName=r.getEstate().getEstateName();
           List<Admin> admins = afl.findInEst(estateName);
           request.setAttribute("admins", admins);
           url = "va.jsp";
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
