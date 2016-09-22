<%-- 
    Document   : index
    Created on : 21 Sep, 2016, 5:51:33 PM
    Author     : Sunandan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="f1" enctype="multipart/form-data" action="DisplayServlet" method="post">
            <input type="file" name="file">
            <input type="submit" value="upload">
        </form>
    </body>
</html>
