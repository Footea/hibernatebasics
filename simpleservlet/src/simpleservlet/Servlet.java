package simpleservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", urlPatterns={"/Servlet"})
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head></head><body>");
        String login = request.getParameter("login");
        String codename = request.getParameter("codename");
        out.println("<h1>Is this Your Secret Identity</h1>");
        out.println("<p>Machine Identity: " + login + "</p>");
        out.println("<p>Transformer Name: " + codename + "</p>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("This resource is not available directly.");
    }
}
