<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.cyan.min.css"/>
    <title>StartUp</title>
</head>
<body>

<main class="container">
    <article>
        <header align="center">
            <hgroup>
                <h2>Bienvenid@ al sistema de registro/login</h2>
                <p>Sistema de manejo de StartUp</p>
            </hgroup>
        </header>
        <section class="grid">
            <button onclick="location.href='registro.jsp'" type="button">Registro</button>
            <button onclick="location.href='login.jsp'" type="button" class="secondary">Iniciar Sesión</button>
        </section>
    </article>
</main>
</body>
</html>