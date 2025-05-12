<%-- 
    Document   : announcements
    Created on : 29 Apr 2025, 12:02:55 PM
    Author     : Palesa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Announcement Page</title>
    </head>
    <body>
        <h1>Announcement Page</h1>
        <form action="ControllerServlet.do" method="Post"> 
        <textarea name="announcement" placeholder="Enter announcement" required></textarea>
       <button type="submit">Post Announcement</button>
        </form>
    </body>
</html>
