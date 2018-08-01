<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import ="java.io.File" %>
<%@ page import ="java.util.ArrayList" %>
<%@ page import ="java.util.List" %>
<%@ page import ="com.shoppingapp.controller.User" %>
<%@ page import ="com.shoppingapp.pojos.ProductDetails" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border=1 align="center">
<tr>
<th>Product ID</th>

<th>Product Name</th>

<th>Product Price</th>

<th>Stock</th>

<th>Purchase</th>
</tr>

  <c:forEach var="columnHeader" items="${productList}">

  <tr>
  	    <td><c:out value="${columnHeader.getProductID()}" /></td>
        <td><c:out value="${columnHeader.getProductName()}" /></td>
        <td><c:out value="${columnHeader.getPrice()}" /></td>
        
       <c:if test="${columnHeader.getQuantity()>0}">
       <td><h3 style="color:Green;"><center>Available</center>  </h3></td>
       
       </c:if>
       
       <c:if test="${columnHeader.getQuantity()<=0}">
		<td ><h3 style="color:red;"><center>Not Available</center></h3> </td>
       
       </c:if>

       <td> 
       <form action="Order" method="POST">
       <input type="hidden" name="productID" value="<c:out value="${columnHeader.getProductID()}"/>">
       <input type="Submit" value="Buy Now" />
       </form> 
       </td>
  </tr>

        
        <br>
  </c:forEach>
</table>

</body>
</html>