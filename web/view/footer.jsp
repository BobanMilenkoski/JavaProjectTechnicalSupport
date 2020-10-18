<%-- 
    Document   : footer
    Created on : Aug 12, 2020, 9:05:57 PM
    Author     : boban
--%>

<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <LINK REL="StyleSheet" HREF="<%=request.getContextPath()%>/styles/main.css" TYPE="text/css">
        
    </head>
    <body>
        <p class="right"> &copy; <%= LocalDate.now().getYear() %> SportsPro, Inc. </p>
    </body>
</html>
