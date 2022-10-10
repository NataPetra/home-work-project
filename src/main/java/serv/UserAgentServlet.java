package serv;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "userAgentServlet", urlPatterns = "/userAgent")
public class UserAgentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=Windows-1251");
        PrintWriter respWriter = resp.getWriter();
        String userAgent = req.getHeader("User-Agent");
        String user = userAgent.toLowerCase();
        String browser = "";

        if (user.contains("msie")) {
            String substring = userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
            browser = substring.split(" ")[0].replace("MSIE", "IE");
        } else if (user.contains("safari") && user.contains("version")) {
            browser = (userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0];
        } else if (user.contains("opr") || user.contains("opera")) {
            if (user.contains("opera"))
                browser = (userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0];
            else if (user.contains("opr"))
                browser = ((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).split("/")[0].replace("OPR", "Opera"));
        } else if (user.contains("edg")) {
            browser = ((userAgent.substring(userAgent.indexOf("Edg")).split(" ")[0]).split("/")[0]).replace("Edg", "Microsoft Edge");
        } else if (user.contains("chrome")) {
            browser = (userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0].split("/")[0]);
        } else if (user.contains("firefox")) {
            browser = (userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).split("/")[0];
        } else if (user.contains("rv")) {
            browser = "IE-" + user.substring(user.indexOf("rv") + 3, user.indexOf(")"));
        } else {
            browser = "Unknown, More-Info: " + userAgent;
        }
        respWriter.println("<html>" + "<body>" + "<h2>" + "Приветствую пользователя " + browser + "</h2>" + "</body>" + "</html>");

    }
}
