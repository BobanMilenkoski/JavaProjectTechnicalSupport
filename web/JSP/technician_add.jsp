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
        <title>ADD technician</title>
        <LINK REL="StyleSheet" HREF="<%=request.getContextPath()%>/styles/main.css" TYPE="text/css">
        
<script type="text/javascript">
            


function validateEmail()

{

var emailID = document.myForm.email.value;

atpos = emailID.indexOf("@");

dotpos = emailID.lastIndexOf(".");

if (atpos < 1 || ( dotpos - atpos < 2 ))

{

alert("Please enter correct email ID");

document.myForm.email.focus() ;

return false;

}

return( true );

}


function validate()

{

var x = document.forms["myForm"]["firstName"].value;
if( x == "" )

{

alert( "Please provide your name!" );

document.myForm.firstName.focus() ;

return false;

}

var y = document.forms["myForm"]["lastName"].value;
if( y == "" )

{

alert( "Please provide your last name!" );

document.myForm.lastName.focus() ;

return false;

}

if( document.myForm.email.value === "" )

{

alert( "Please provide your Email!" );

document.myForm.email.focus() ;

return false;

}

else

{

var ret = validateEmail();

if( ret === false )

{

return false;

}
}

var phoneNumber = document.getElementById('phone').value;
  
  var phoneRGEX = /^[(]{0,1}[0-9]{3}[)]{0,1}[-\s\.]{0,1}[0-9]{3}[-\s\.]{0,1}[0-9]{4}$/;
  
  var phoneResult = phoneRGEX.test(phoneNumber);
  
  if(phoneResult == false)
  {
    alert('Please enter a valid phone number! Format XXX-XXX-XXXX');
    
    document.myForm.phone.focus() ;
    return false;
  }


if( document.myForm.password.value =="" ||

document.myForm.regno.value.length < 6 );

{

alert( "Please provide a valid password." );

document.myForm.password.focus() ;

return false;

}



return( true );

}

</script>
    
    </head>
        <body>
    
        <h1>Add Technician</h1>
    
    <form name="myForm" action="<%= request.getContextPath() %>/TechnicianServlet" onsubmit="return validate()" method="post">
        <input type="hidden" name="action" value="add">        
        
        <label class="pad_top">First Name:</label>
        <input type="text" name="firstName" value="${technician.firstName}" 
               ><br>
        <label class="pad_top">Last Name:</label>
        <input type="text" name="lastName" value="${technician.lastName}" 
               ><br>
        <label class="pad_top">Email:</label>
        <input type="text" name="email" value="${technician.email}"  
               ><br> 
        <label class="pad_top">Phone:</label>
        <input type="text" name="phone" id = "phone" value="${technician.phone}"  
               ><br>  
        <label class="pad_top">Password:</label>
        <input type="text" name="password" value="${technician.password}"  
               ><br>  
        <label>&nbsp;</label>
        <input type="submit" value="Add Technician" class="margin_left">
    </form>
              
        <br><div><a href='<%= request.getContextPath() %>/TechnicianServlet'> View Technician List</a></div>
               
        <jsp:include page="/view/footer.jsp" />
</body>

