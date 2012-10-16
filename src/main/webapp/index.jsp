
<%@page import="com.mycompany.afterupdate.DbConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body bgcolor="#4f6895"> 

        <h1><FONT COLOR="#eb821c">After Update</FONT></h1>

        <%
            out.println("<p>Database info: " + new DbConnection().getDbInfo() + "</p>");
            out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
        %>

    </body>
</html>

