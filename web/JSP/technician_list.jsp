<%-- 
    Document   : productList
    Created on : Aug 3, 2020, 7:52:36 PM
    Author     : boban
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/view/header.html" />

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Technician List</title>
        <LINK REL="StyleSheet" HREF="<%=request.getContextPath()%>/styles/main.css" TYPE="text/css">
    </head>
        <body>
            <h1>Technician List</h1>
        
        <table width="100%">
            <tr>
                
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Password</th>
                	
            </tr>
            <c:forEach items="${Technicians}" var="item">
                
                <tr>
                                       
                    <td><c:out value="${item.firstName}" /></td>
                    <td><c:out value="${item.lastName}" /></td>
                    <td><c:out value="${item.email}" /></td>  
                    <td><c:out value="${item.phone}" /></td> 
                    <td><c:out value="${item.password}" /></td> 
                    <td>
            
            <form action="TechnicianServlet" method="post">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="productCode"
                       value='<c:out value="${item.firstName}" />'>
                <input type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete?')">               
            </form>
                    
                </tr>
            </c:forEach>
        </table>
        
        <p><a href="<%= request.getContextPath() %>/JSP/technician_add.jsp">Add Technician</a></p>
        
        <jsp:include page="/view/footer.jsp" />
    </body>
</html>
