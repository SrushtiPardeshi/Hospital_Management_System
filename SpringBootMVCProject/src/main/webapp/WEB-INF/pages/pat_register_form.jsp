<%@ page isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>



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
<body bgcolor="EEEEEE">
<header>
<a href="./"><h1 style="text-align:center ;font-size:60px">Registration Form</h1></a></header>
<br><br><br>
<div id="main">
<div class="first"> 
<frm:form modelAttribute="pat">
  <table align="center" height=200px>
   <tr>
      <td>Patient Name</td>
      <td><frm:input path="pname" /></td>
   </tr>
   
   <tr>
      <td>Patient Address</td>
      <td><frm:input path="paddrs" /></td>
   </tr>
   
   <tr>
      <td>Mobile No</td>
      <td><frm:input path="mobileno" /></td>
   </tr>
   
   <tr>
      <td>Covid Infected</td>
      <td><frm:input path="coronavirus" /></td>
   </tr>
    
    <tr>
    <td><input type="submit" value="register"></td>
    <td><input type="reset" value="reset"></td>
    </tr>
    
   </table>

</frm:form>
</div>
<div></div>
</div>
</body>
</html>