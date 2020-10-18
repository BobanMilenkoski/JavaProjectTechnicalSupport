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
      <title>Product List</title>
       
      <LINK REL="StyleSheet" HREF="<%=request.getContextPath()%>/styles/main.css" TYPE="text/css">
    
    </head>
    <body>
        <h1>Product List</h1>
        
        <table width="100%">
            <tr>
                <th>Product Code</th>
                <th>Name</th>
                <th>Version</th>
                <th>Release Date</th>                	
            </tr>
            
            <c:forEach items="${Products}" var="item">
                
                <tr>
                    <td><c:out value="${item.productCode}" /></td>                    
                    <td><c:out value="${item.name}" /></td>
                    <td><c:out value="${item.version}" /></td>
                    <td><c:out value="${item.releaseDate}" /></td>   
                                       
                    <td>
                        
            <form action="ProductServlet" method="post">
                <input type="hidden" name="action"
                       value="delete">
                <input type="hidden" name="productCode"
                       value='<c:out value="${item.productCode}" />'>
                <input type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete?')">              
            </form>
                
                    </td>                                                      
                </tr>
            </c:forEach>
                               
        </table>
        
        <p><a href="<%= request.getContextPath() %>/JSP/product_add.jsp">Add Product</a></p>
        
        <jsp:include page="/view/footer.jsp" />
    </body>
</html>
