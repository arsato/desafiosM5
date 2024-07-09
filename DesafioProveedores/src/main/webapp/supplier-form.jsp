<%--
  Created by IntelliJ IDEA.
  User: Ariel Sandoval Toro
  Date: 08-07-2024
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Add New Supplier</title>
</head>
<body>
<h1>Add New Supplier</h1>
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
<a href="proveedores">Back to Suppliers List</a>
</body>
</html>