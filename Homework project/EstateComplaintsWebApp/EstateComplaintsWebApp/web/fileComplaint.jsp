<%-- 
    Document   : fileComplaint
    Created on : 29 Apr 2025, 11:44:50 AM
    Author     : Palesa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Complaints Page</title>
    </head>
    <body>
        <h1>Complaints Page</h1>
        <p>
            You can file your complaint below.
        </p>
        <form action="ControllerServlet.do" method="post">
         <input type="text" name="problemType" placeholder="Problem Type" required />
         <textarea name="description" placeholder="Describe the problem" required></textarea>
          <buton type="submit">Submit Complaint</button>
</form>

    </body>
</html>
