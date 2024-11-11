<%@ page isELIgnored="false" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<style>
#all{
    display: flex;
    justify-content: space-around;
}

</style>
</head>
<body bgcolor="64FFDA" text-size=50px>
<header><div><center><a href="./"><h1 style="font-size:50px; color:black">ADMIN DASHBORED PAGE</h1></a></center></div></header><br><br>
<div id="all">



<div class="content">
<c:choose>
   <c:when test="${!empty patarray}">
     <table border="3" align="center" bgcolor="ECEFF1" box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;>
       <tr><th>PatientId</th><th>PatientName</th><th>Address</th><th>MobileNo</th> <th>Covid</th> </tr>
       
        <c:forEach var="pat" items="${patarray}">
        <tr>
            <td>${pat.pid}</td>
         <td>${pat.pname}</td>
         <td>${pat.paddrs}</td>
         <td>${pat.mobileno}</td>
         <c:choose>
            <c:when test="${pat.coronavirus==true}">
               <td style="background-color: red;">Positive</td>
            </c:when>
            <c:otherwise> 
               <td style="background-color: green;">Negative</td>
            </c:otherwise>
         </c:choose>
         <td><a href="edit?id=${pat.pid}"><img src="images/edit.png" width="25px" height="25px"/></a></td>
               &nbsp;&nbsp;
                  <td><a href="delete?id=${pat.pid}" onclick="return confirm('are you sure to delete PatientRecord??')"><img src="images/delete.jpg" width="30px" height="25px"/></a></td>
                  
          </tr>     
            
        </c:forEach>
     </table>
    </c:when>
    
    <c:otherwise>
      <h1 style="color:red;text-align:center">No Record Found</h1>
</c:otherwise>
    
</c:choose>
</div>
</div>

<center><h1 style="color:Black">${resultMsg}</h1></center>
</body>
</html>