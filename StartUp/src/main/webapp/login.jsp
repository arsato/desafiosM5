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
    <title>Login</title>
</head>
<body>
<main class="container">
    <article>
        <h2 align="center">Inicio de sesión</h2>
        <form action="login" method="post">
            <input value="ariel@mail.com" type="email" id="email" name="email" placeholder="Email" autocomplete="email"
                   aria-invalid="${message == 'mail not found' ? 'true' : ''}" required>
            <c:if test="${message == 'mail not found'}">
                <small>¡Correo inválido!</small>
                <hr>
            </c:if>
            <input type="password" id="password" name="password" placeholder="Contraseña"
                   aria-invalid="${message == 'wrong password' ? 'true' : ''}" required>
            <c:if test="${message == 'wrong password'}">
                <small>¡Contraseña Incorrecta!</small>
                <hr>
            </c:if>
            <input type="submit" value="Iniciar Sesión">
        </form>
    </article>
</main>
</body>
</html>