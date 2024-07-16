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
    <title>Registro</title>
</head>
<body>
<div class="flex flex-col bg-slate-500 w-full min-h-screen">
    <main class="w-full mx-auto max-w-2xl items-center px-12 py-12">
            <h2 class="text-center text-2xl mb-5 text-blue-100">Registro de nuevo usuario</h2>
            <form action="register" method="post"
                  class="w-auto rounded-xl drop-shadow border-gray-700 bg-gray-800 p-8 text-lg">
                <div class="flex flex-col">
                    <h3 class="text-center text-2xl text-blue-100">Datos de usuario</h3>
                    <input class="${message != null ? 'mt-5 rounded-xl border-2 border-rose-500 p-4 pl-6' : 'mt-5 rounded-xl p-4 pl-6'}"
                           placeholder="Correo electrónico" type="email" id="email" name="email" required/>
                    <c:if test="${message != null}">
                        <p class="text-rose-500 font-semibold text-sm">${message}</p>
                    </c:if>
                    <input class="mt-5 rounded-xl p-4 pl-6" placeholder="Contraseña" type="password" id="password"
                           name="password" required/>
                    <hr class="mt-5"/>
                    <h3 class="text-center text-2xl text-blue-100">Datos Personales</h3>
                    <input class="mt-5 rounded-xl p-4 pl-6" placeholder="Nombre" type="text" id="name" name="name"
                           required/>
                    <input class="mt-5 rounded-xl p-4 pl-6" placeholder="Apodo" type="text" id="nick" name="nick"
                           required/>
                    <input class="mt-5 rounded-xl p-4 pl-6" placeholder="Peso" type="number" id="weight" name="weight"
                           required/>
                    <input class="mt-5 rounded-xl p-4 pl-6" placeholder="Dirección" type="text" id="addressName" name="addressName"
                           required/>
                    <input class="mt-5 rounded-xl p-4 pl-6" placeholder="Numeración" type="text" id="addressNumber" name="addressNumber"
                           required/>
                    <input class="mt-5 rounded-xl bg-blue-900 p-4 font-medium text-white duration-300 ease-in-out hover:scale-[1.02] hover:cursor-pointer hover:bg-blue-700"
                           type="submit" value="Registrate"/>
                </div>
            </form>
        <button onclick="location.href='index.jsp'" type="button" class="mt-8 max-w-[150px] flex items-center justify-center px-5 py-2 text-sm text-gray-200 transition-colors duration-200 bg-gray-900 border rounded-lg gap-x-2 hover:bg-gray-800  border-gray-700">
            <svg class="w-5 h-5 rtl:rotate-180" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" d="M6.75 15.75L3 12m0 0l3.75-3.75M3 12h18" />
            </svg>
            <span>Volver Atrás</span>
        </button>
    </main>
</div>
</body>
</html>
