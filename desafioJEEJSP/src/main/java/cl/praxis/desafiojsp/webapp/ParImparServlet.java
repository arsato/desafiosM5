package cl.praxis.desafiojsp.webapp;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ParImparServlet", value = "/parimpar")
public class ParImparServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String numStr = request.getParameter("num");
        response.setContentType("text/html");
        int num = Integer.parseInt(numStr);

        if (num % 2 == 0)
            response.getWriter().append("<h1>El Número ").append(String.valueOf(num)).append(" es Par!</h1>");
        else
            response.getWriter().append("<h1>El Número ").append(String.valueOf(num)).append(" es Impar</h1>");

    }
}
