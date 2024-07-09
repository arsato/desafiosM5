<%--
  Created by IntelliJ IDEA.
  User: Ariel Sandoval Toro
  Date: 08-07-2024
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Suppliers List</title>
</head>
<body>
<h1>Supplier List</h1>
<a href="proveedores?action=new">Add New Supplier</a><br>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Rut</th>
        <th>Address</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Contact Name</th>
        <th>Contact Phone</th>
    </tr>
    <!-- Iterar sobre la lista de usuarios y mostrar sus datos en la tabla -->
    <c:forEach var="supplier" items="${listSuppliers}">
        <tr>
            <td>${supplier.name}</td>
            <td>${supplier.rut}</td>
            <td>${supplier.address}</td>
            <td>${supplier.email}</td>
            <td>${supplier.phone}</td>
            <td>${supplier.contactName}</td>
            <td>${supplier.contactPhone}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
