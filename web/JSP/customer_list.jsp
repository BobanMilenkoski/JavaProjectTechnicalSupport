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
        <title>Customer List</title>
        <LINK REL="StyleSheet" HREF="<%=request.getContextPath()%>/styles/main.css" TYPE="text/css">
    </head>
    <body>
        <h1>View Customers</h1>
        <table width="100%">
            <tr>
                
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>Postal Code</th>
                <th>Country</th>
                <th>Phone</th>
                <th>Email</th>
                
                	
            </tr>
            <c:forEach items="${Customers}" var="item">
                
                <tr>                   
                    <td><c:out value="${item.firstName}" /></td>
                    <td><c:out value="${item.lastName}" /></td>
                    <td><c:out value="${item.address}" /></td>  
                    <td><c:out value="${item.city}" /></td>
                    <td><c:out value="${item.state}" /></td>
                    <td><c:out value="${item.postalCode}" /></td>
                    <td><c:out value="${item.countryCode}" /></td>
                    <td><c:out value="${item.phone}" /></td>
                    <td><c:out value="${item.email}" /></td>
                                                                                  
                </tr>
            </c:forEach>
        </table>
    </body>
    
    <jsp:include page="/view/footer.jsp" />
</html>

