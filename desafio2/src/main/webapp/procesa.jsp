<%--
  Created by IntelliJ IDEA.
  User: Ariel Sandoval Toro
  Date: 26-06-2024
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="cl.praxis.desafio2.model.Habitacion" %>
<%@ page import="cl.praxis.desafio2.business.HabitacionBusiness" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    String email = request.getParameter("email");
    String medioPago = request.getParameter("medio_pago");
    int dias = Integer.parseInt(request.getParameter("dias"));
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    Date fechaEntrada;
    String strDate;
    try {
        fechaEntrada = formato.parse(request.getParameter("fecha_entrada"));
        SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy");
        strDate = formatter.format(fechaEntrada);
    } catch (ParseException e) {
        throw new RuntimeException(e);
    }

    int idHabitacion = Integer.parseInt(request.getParameter("id_habitacion"));

    HabitacionBusiness hb = new HabitacionBusiness();

    Habitacion habitacion = new Habitacion();

    habitacion.setId(idHabitacion);

    habitacion = hb.getHabitacionById(habitacion);

    int totalPagar = 0;

    if (habitacion != null)
        totalPagar = hb.calcularValorCompra(habitacion.getPrecio(), dias);
%>

<!DOCTYPE html>
<html lang="es">

<%@include file="assets/html/head.jsp"%>

<body>
<%@include file="assets/html/header.jsp"%>

<form method="post" action="procesa.jsp">

    <!-- Section-->
    <section class="py-5">
        <div class="container px-4 px-lg-5 mt-5">

            <div class="row justify-content-center">
                <h1>
                    Detalle Solicitud Habitación: <strong><%=habitacion.getNombre()%></strong>
                </h1>
                <hr />
            </div>
        </div>

        <div class="container px-4 px-lg-5 mt-5">

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Item</th>
                    <th scope="col">Valor</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Nombre</td>
                    <td><%=nombre%></td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Apellido</td>
                    <td><%=apellido%></td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>Email</td>
                    <td><%=email%></td>
                </tr>
                <tr>
                    <th scope="row">4</th>
                    <td>Medio de Pago</td>
                    <td><%=medioPago%></td>
                </tr>
                <tr>
                    <th scope="row">5</th>
                    <td>Dias</td>
                    <td><%=dias%></td>
                </tr>
                <tr>
                    <th scope="row">6</th>
                    <td>Fecha Entrada</td>
                    <td><%=strDate%></td>
                </tr>
                <tr>
                    <th scope="row">6</th>
                    <td>Valor a Pagar</td>
                    <td><strong>CLP$ <%=totalPagar%></strong></td>
                </tr>
                </tbody>
            </table>

        </div>
    </section>
    <br /> <br />
</form>

<%@include file="assets/html/footer.jsp"%>
</body>
</html>