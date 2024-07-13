<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>StartUp</title>
</head>
<body>

<main class="flex flex-col items-center justify-center bg-slate-500 w-full h-lvh">
    <div class="w-full h-2/6 flex flex-col items-center justify-center rounded-lg border p-4 text-center shadow border-gray-700 bg-gray-800">
        <h5 class="mb-2 text-3xl font-bold text-white">Sistema de gestión y administración de vehículos</h5>
        <p class="mb-5 text-base sm:text-lg text-gray-400">Favor registrarse o iniciar sesión.</p>
        <div class="items-center justify-center">
            <button class="mb-2 me-2 w-[150px] rounded-full bg-green-700 px-5 py-2.5 text-center text-sm font-medium text-white hover:bg-green-600 duration-300 ease-in-out hover:scale-[1.02]"
                    onclick="location.href='registro.jsp'" type="button">Registro
            </button>
            <button class="mb-2 me-2 w-[150px] rounded-full bg-blue-900 px-5 py-2.5 text-center text-sm font-medium text-white hover:bg-blue-700 duration-300 ease-in-out hover:scale-[1.02]"
                    onclick="location.href='login.jsp'" type="button">Inicio de Sesión
            </button>
        </div>
    </div>
</main>
</body>
</html>