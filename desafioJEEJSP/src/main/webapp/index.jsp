<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">

  <title>Desafio 1 JEE/JSP</title>
</head>
<body class="p-5">

<h1><%= "Desafío 1 JEE/JSP" %></h1>

<table class="table table-success table-striped">
  <thead>
  <tr>
    <th scope="col">#</th>
    <th scope="col">Número</th>
    <th scope="col">Calcular Factorial</th>
    <th scope="col">¿Es par o impar?</th>
  </tr>
  </thead>

  <tbody>
  <% for (int i = 0 ; i <= 10 ; i++) { %>
  <tr>
    <th scope="row"><%=i%></th>
    <td>Número <%=i%></td>
    <td><a href="factorial?num=<%=i%>">Factorial de <%=i%></a></td>
    <td><a href="parimpar?num=<%=i%>">¿Es par o impar el número <%=i%>?</a></td>
  </tr>
  <% } %>
  </tbody>

</table>

<script
        src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous">
</script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous">
</script>
</body>
</html>