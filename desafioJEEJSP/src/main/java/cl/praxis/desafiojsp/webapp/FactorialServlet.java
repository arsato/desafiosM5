package cl.praxis.desafiojsp.webapp;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "FactorialServlet", value = "/factorial")
public class FactorialServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String numStr = request.getParameter("num");
        response.setContentType("text/html");
        int num = Integer.parseInt(numStr);
        int resultadoFactorial = calcularFactorial(num);

        response.getWriter().append("<h1>El Factorial del Número ").append(String.valueOf(num)).append(" es ").append(String.valueOf(resultadoFactorial)).append("!</h1>");
    }

    public static int calcularFactorial(int n) {
        int factorial = 1;
        for (int i = 2; i <= n; ++i) {
            factorial *= i;
        }
        return factorial;
    }
}
