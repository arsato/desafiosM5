<%@ page import="cl.praxis.calculatorservlet.services.CalculatorService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css"/>
  <title>Desafío Calculator Servlet</title>
</head>
<body>

<main class="container">
  <c:set var="operations" value="<%= new CalculatorService().getOperations().entrySet() %>"/>

  <h1>Calculadora</h1>

  <form method="post" action="calculator">
    <fieldset>
      <input type="number" name="number1" placeholder="Número 1" required/>
      <input type="number" name="number2" placeholder="Número 2" required/>

      <select name="operation" required>
        <option selected disabled value="">
          Seleccione una Operación
        </option>
        <c:forEach var="operation" items="${operations}">
          <option value="${operation.key}">${operation.value}</option>
        </c:forEach>
      </select>
    </fieldset>
    <input type="submit" value="Calcular"/>
  </form>

  <article>
    <h2>Resultado</h2>
    <h4><c:out value="${calcResponse != null ? calcResponse : ''}"/></h4>
  </article>
</main>

</body>
</html>