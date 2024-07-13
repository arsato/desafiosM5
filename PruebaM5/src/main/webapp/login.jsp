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
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Login</title>
</head>
<body>
<div class="flex flex-col bg-slate-500 w-full h-lvh">
    <main class="w-full mx-auto max-w-2xl items-center px-12 py-12">
        <article>
            <h2 class="text-center text-2xl mb-5 text-blue-100">Inicio de sesión</h2>
            <form action="login" method="post"
                  class="w-auto rounded-xl drop-shadow border-gray-700 bg-gray-800 p-8 text-lg">
                <div class="flex flex-col">
                    <input class="${message == 'mail not found' ? 'rounded-xl border-2 border-rose-500 p-4 pl-6' : 'rounded-xl p-4 pl-6'}"
                           value="ariel@mail.com" type="email" id="email" name="email" placeholder="Email"
                           autocomplete="email" required>
                    <c:if test="${message == 'mail not found'}">
                        <p class="text-rose-500 font-semibold text-sm">¡Correo inválido!</p>
                    </c:if>
                    <input class="${message == 'wrong password' ? 'rounded-xl border-2 border-rose-500 p-4 pl-6 mt-5' : 'rounded-xl p-4 pl-6 mt-5'}"
                           type="password" id="password" name="password" placeholder="Contraseña" required>
                    <c:if test="${message == 'wrong password'}">
                        <p class="text-rose-500 font-semibold text-sm">¡Contraseña Incorrecta!</p>
                    </c:if>
                    <input class="mt-5 rounded-xl bg-blue-900 p-4 font-medium text-white duration-300 ease-in-out hover:scale-[1.02] hover:cursor-pointer hover:bg-blue-700"
                           type="submit" value="Iniciar Sesión">
                </div>
            </form>
        </article>
    </main>
</div>
</body>
</html>