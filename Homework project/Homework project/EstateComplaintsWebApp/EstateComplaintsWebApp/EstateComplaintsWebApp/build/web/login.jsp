<%-- 
    Document   : login
    Created on : 29 Apr 2025, 11:37:13 AM
    Author     : Palesa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
         <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h1>Login Page</h1>
        
        <p>
            Login Below:
        </p>
        <form action="ControllerServlet.do" method="post">
            <table>
                <tr>
                    <td>ID Number:</td>
                     <td><input type="text" name="id" required=""></td>
                </tr>
                     <tr>
                    <td>Password:</td>
                     <td><input type="text" name="password" required=""></td>
                </tr>
                    <tr>
                    <td><input type="hidden" name="operation" value="login"></td>
                     <td><input type="submit" value="LOGIN"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
