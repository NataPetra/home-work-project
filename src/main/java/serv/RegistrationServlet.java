package serv;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "regServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String address = req.getParameter("address");
        String contact = req.getParameter("contact");
        if (username==null || username.isEmpty()){
            resp.sendRedirect(req.getContextPath()+"/jsp/error.jsp");
            return;
        }
        if (address==null && contact == null){
            resp.sendRedirect(req.getContextPath()+"/jsp/error.jsp");
        }
    }
}
