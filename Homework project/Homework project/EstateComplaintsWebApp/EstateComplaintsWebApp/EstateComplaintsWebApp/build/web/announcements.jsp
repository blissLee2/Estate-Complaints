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
         <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h1>Announcement Page</h1>
        <form action="ControllerServlet.do" method="Post"> 
            <table>
                <tr>
                    <td>Announcement:</td>
        <td><textarea name="announcement" placeholder="Enter announcement" required></textarea></td>
        </tr>
        <tr>
            <td><input type="hidden" name="operation" value="announce"></td>
       <td><button type="submit">Post Announcement</button></td>
       </tr>
            </table>
        </form>
    </body>
</html>
