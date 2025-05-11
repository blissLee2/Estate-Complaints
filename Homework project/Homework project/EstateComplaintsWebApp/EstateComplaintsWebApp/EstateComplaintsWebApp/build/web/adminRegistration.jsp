<%-- 
    Document   : adminRegistration
    Created on : 28 Apr 2025, 9:43:05 PM
    Author     : Palesa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administration Registration Page</title>
         <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h1>Administration Registration</h1>
        
        <p>
            Please enter your details below.
        </p>
        <form action="ControllerServlet.do" method="post">
            <table>
                <tr>
                    <td>ID Number:</td>
                    <td><input type="text" name="id" required=""></td>
                </tr>
                      <tr>
                    <td>Estate Name:</td>
                    <td><input type="text" name="estateName" required=""></td>
                </tr>
                      <tr>
                    <td>Full Names:</td>
                    <td><input type="text" name="name" required=""></td>
                </tr>
                       <tr>
                    <td>Email Address:</td>
                    <td><input type="text" name="email" required=""></td>
                </tr>
                       <tr>
                    <td>Password:</td>
                    <td><input type="text" name="password" required=""></td>
                </tr>
                   <tr>
                       <td><input type="hidden" name="operation" value="register"></td>
                       <td><input type="submit" value="REGISTER"></td>
                       <td><input type="hidden" name="regType" value="admin"></td>
                       
                       </tr>
    </body>
</html>
