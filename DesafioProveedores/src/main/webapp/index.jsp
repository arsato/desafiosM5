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
<h2>Add New Supplier</h2>
<form action="proveedores?action=insert" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${supplier.name}" required><br>
    <label for="rut">Rut:</label>
    <input type="text" id="rut" name="rut" value="${supplier.rut}" required><br>
    <label for="address">Address:</label>
    <input type="text" id="address" name="address" value="${supplier.address}" required><br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${supplier.email}" required><br>
    <label for="phone">Phone:</label>
    <input type="number" id="phone" name="phone" value="${supplier.phone}" required><br>
    <label for="contactName">Name:</label>
    <input type="text" id="contactName" name="contactName" value="${supplier.contactName}" required><br>
    <label for="contactPhone">Contact Phone:</label>
    <input type="number" id="contactPhone" name="contactPhone" value="${supplier.contactPhone}" required><br>
    <input type="submit" value="Add">
</form>

<h1>Supplier List</h1>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Rut</th>
        <th>Address</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Contact Name</th>
        <th>Contact Phone</th>
        <th>Actions</th>
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
            <td>
                <a href="proveedores?action=edit&id=${supplier.id}">Edit</a>
                <a href="proveedores?action=delete&id=${supplier.id}" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
