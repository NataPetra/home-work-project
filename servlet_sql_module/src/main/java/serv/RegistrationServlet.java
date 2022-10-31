package serv;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "regServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String address = req.getParameter("address");
        String contact = req.getParameter("contact");
        if (username.isEmpty()){
            resp.sendRedirect(req.getContextPath()+"/jsp/error.jsp");
            return;
        }
        if (address.isEmpty() && contact.isEmpty()){
            resp.sendRedirect(req.getContextPath()+"/jsp/error.jsp");
            return;
        }
        if (!address.matches("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$")){
            resp.sendRedirect(req.getContextPath()+"/jsp/error.jsp");
            return;
        }
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Your personal information</h1>");
        writer.println("<h3>User name: " + username + "</h3>");
        if (!contact.isEmpty()) {
            writer.println("<h3>Contact: " + contact + "</h3>");
        }
        if (!address.isEmpty()) {
            writer.println("<h3>Address: " + address + "</h3>");
        }

    }
}
