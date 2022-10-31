package serv;

import classes.Counter;
import classes.FileForCounter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "counterServletText", urlPatterns = "/counterText")
public class CounterServletText extends HttpServlet {

    private Counter counter;
    int number;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        counter = new Counter();
        FileForCounter.createFile();
        number = counter.checkFile();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        number++;
        PrintWriter respWriter = resp.getWriter();
        respWriter.println("<h1>Amount of view of this servlet: " + number + " generally.</h1>");
        counter.writeInt(number);
    }
}

