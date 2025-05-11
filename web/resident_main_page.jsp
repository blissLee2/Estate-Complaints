<%-- 
    Document   : resident_main_page
    Created on : Apr 29, 2025, 4:58:51 PM
    Author     : General_user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resident Main Page</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h1>Resident Main Page </h1>
        <p>
            Please select the action you want.
        </p>
        <ul>
            <li><a href="fileComplaint.jsp">File A Complaint</a></li>
            <li><a href="viewAnnouncements.jsp">View Announcements</a></li>
        </ul>
        <form action="ControllerServlet.do" method="post"  class="logout-form">
            <table align="center">
            <input type="hidden" name="operation" value="logout">
            <button type="submit" onclick="return confirm('Are you sure you want to logout?')" style="background: none; border: none; color: blue; text-decoration: underline; cursor: pointer;">LOGOUT</button>
            </table>
           
        </form>

    </body>
</html>
