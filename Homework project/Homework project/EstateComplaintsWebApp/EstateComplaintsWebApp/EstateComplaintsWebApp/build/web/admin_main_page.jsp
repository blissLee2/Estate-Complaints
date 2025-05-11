<%-- 
    Document   : admin_main_page
    Created on : Apr 29, 2025, 4:57:52 PM
    Author     : General_user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Main Page</title>
         <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h1>Admin Main Page</h1>
        <p>
            Please select the action you want.
        </p>
        <ul>
            <li><a href="announcements.jsp">Make Announcement</a></li>
            <li><form action="ControllerServlet.do" method="post">
                <button type="submit" style="background: none; border: none; color: blue; text-decoration: underline; cursor: pointer;">
                View Complaints
                </button>
                    <p><input type="hidden" name="operation" value="view_complain"></p> 
                </form>
            </li>
    
        </ul>
    </body>
</html>
