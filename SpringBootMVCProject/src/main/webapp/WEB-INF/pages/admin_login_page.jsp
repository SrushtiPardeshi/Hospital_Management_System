<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<style>
 input {
    outline:none;
}
 #main{
   display:flex;
 }
 
 .first{
   height:200px;
   margin:auto;
   background-color:white;
   padding:30px;
   box-shadow: rgba(50, 50, 93, 0.25) 0px 50px 100px -20px, rgba(0, 0, 0, 0.3) 0px 30px 60px -30px, rgba(10, 37, 64, 0.35) 0px -2px 6px 0px inset;
   
 }
</style>
</head>
<body bgcolor="80DEEA">
<header>
<a href="./"><h1 style="text-align:center ;font-size:60px">Admin Login Page</h1></a></header>
<br><br><br>
<div id="main">
<div class="first"> 
<form action="adminlog" method="POST">
  <table align="center" height=200px>
   <tr>
      <td>Admin Username</td>
      <td><input type="text" name="username" placeholder="Enter Admin Id"></td>
   </tr>
   
   <tr>
      <td>Admin Password</td>
      <td><input type="password" name="password" placeholder="Enter Admin Password"></td>
   </tr>
   
    
    <tr>
    <td><input type="submit" value="submit"></td>
    <td><input type="reset" value="reset"></td>
    </tr>
    
   </table>

</form>
</div>
<div></div>
</div>
</body>
</html>