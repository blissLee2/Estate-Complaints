<%-- 
    Document   : viewAnnouncements
    Created on : 29 Apr 2025, 6:31:54 PM
    Author     : Palesa
--%>

<%@page import="entities.Admin"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Announcements Page</title>
         <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h1>View Announcements Page</h1>
        <form action="ControllerServlet.do" method="POST">
            <table>
                <tr>
                    <td><input type="hidden" name="operation" value="view_Announcements"></td>
                    <td><input type="submit" value="VIEW ANNOUNCEMENTS"></td>
                </tr>
            </table>
            
        </form>
          
    </body>
</html>
