<%-- 
    Document   : product_add
    Created on : Aug 11, 2020, 8:37:11 PM
    Author     : boban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="/view/header.html" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADD Products</title>
        <LINK REL="StyleSheet" HREF="<%=request.getContextPath()%>/styles/main.css" TYPE="text/css">
        
<script type="text/javascript">
            

function validate()

{

var x = document.forms["myForm"]["productCode"].value;
if( x == "" )

{

alert( "Please enter your code!" );

document.myForm.productCode.focus() ;

return false;

}

var y = document.forms["myForm"]["name"].value;
if( y == "" )

{

alert( "Please provide your name!" );

document.myForm.name.focus() ;

return false;

}

var y = document.forms["myForm"]["version"].value;
if( y == "" )

{

alert( "Please enter the version!" );

document.myForm.version.focus() ;

return false;

}

var day = document.getElementById("releaseDate").value;

var regExp = /([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))/;

var result = regExp.test(day);
  
  if(result == false)
  {
    alert('Please enter a valid date! Format yyyy-mm-dd');
    
    document.myForm.releaseDate.focus() ;
    return false;
  }
  
}





</script>
    
    </head>
        <body>
    
            <h1>Add Product</h1>
    
    <form name="myForm" action="<%= request.getContextPath() %>/ProductServlet" onsubmit="return validate()" method="post">
         <input type="hidden" name="action" value="add">

        <label class="pad_top">Code:</label>
        <input type="text" name="productCode" value="${product.productCode}" 
               ><br>
        <label class="pad_top">Name:</label>
        <input type="text" name="name" value="${product.name}" 
               ><br>
        <label class="pad_top">Version:</label>
        <input type="text" name="version" value="${product.version}"  
               ><br> 
        <label class="pad_top">Release Date:</label>
        <input type="text" name="releaseDate" id ="releaseDate" value="${product.releaseDate}"  
               > Use 'yyyy-mm-dd' format <br>  
        <label>&nbsp;</label>
        <input type="submit" value="Add Product" class="margin_left">
    </form>
               
         <br><div><a href='<%= request.getContextPath() %>/ProductServlet'> View Product List</a></div>
               
         <jsp:include page="/view/footer.jsp" />
</body>
