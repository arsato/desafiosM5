<%--
  Created by IntelliJ IDEA.
  User: Ariel Sandoval Toro
  Date: 09-07-2024
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Home</title>
</head>

<body>

<div class="flex flex-col bg-slate-500 w-full min-h-screen">
    <main class="w-10/12 mx-auto items-center px-12 py-12">
        <h1 class="text-center text-2xl mb-5 text-blue-100">Bienvenido ${user.name}!</h1>
        <h2 class="text-center text-xl text-blue-100">Lamentablemente, no se puede acceder a este contenido</h2>

        <button onclick="location.href='login.jsp'" type="button"
                class="mt-8 max-w-[150px] flex items-center justify-center px-5 py-2 text-sm text-gray-200 transition-colors duration-200 bg-gray-900 border rounded-lg gap-x-2 hover:bg-gray-800  border-gray-700">
            <svg class="w-5 h-5 rtl:rotate-180" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                 stroke-width="1.5" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" d="M6.75 15.75L3 12m0 0l3.75-3.75M3 12h18"/>
            </svg>
            <span>Volver Atrás</span>
        </button>

    </main>
</div>

</body>
</html>
