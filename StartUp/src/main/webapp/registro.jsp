<%--
  Created by IntelliJ IDEA.
  User: Ariel Sandoval Toro
  Date: 09-07-2024
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.cyan.min.css"/>
    <title>Registro</title>
</head>
<body>
<main class="container">
    <c:if test="${message != null}">
            <h3 align="center">${message}</h3>
    </c:if>
    <form action="register" method="post">
        <label for="email">Correo</label>
        <input value="ariel@mail.com" type="email" id="email" name="email" aria-invalid="${message != null ? 'true' : ''}" required>
        <label for="password">Contraseña</label>
        <input value="123" type="password" id="password" name="password" required>
        <label for="name">Nombre</label>
        <input value="ariel" type="text" id="name" name="name" required>
        <label for="nick">Apodo</label>
        <input value="arsato" type="text" id="nick" name="nick" required>
        <label for="weight">Peso</label>
        <input value="35" type="number" id="weight" name="weight" required>
        <input type="submit" value="Registrar">
    </form>
</main>
</body>
</html>
