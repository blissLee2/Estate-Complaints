<%-- 
    Document   : va
    Created on : May 1, 2025, 8:19:07 PM
    Author     : General_user
--%>

<%@page import="entities.Admin"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% 
             
        List<Admin> residents = (List<Admin>) request.getAttribute("admins");
        
           for(Admin a:residents){
        %>
             
             <table>
                <tr>
                    <td>name of </td>
                    <td><%=a.getName() %></td>
                </tr>
                <% 
        List<String> announcements = a.getAnnouncements();
        
           for(String an:announcements){
        %>
                <tr>
                    <td></td>
                    <td><%=an %></td>
                </tr>
                
                <%}%>
            </table>
             <%}%>
             
    </body>
</html>
