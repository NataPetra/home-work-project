package serv;

import classes.Counter;
import classes.FileForCounter;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

@WebServlet(name = "counterServletImg", urlPatterns = "/counterImg")
public class CounterServletImg extends HttpServlet {

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
        ServletOutputStream out = resp.getOutputStream();
        resp.setContentType("image/jpeg");
        number++;

        BufferedImage img = new BufferedImage(1000, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = img.createGraphics();
        graphics.setFont(new Font("Arial", Font.BOLD, 32));
        graphics.setBackground(Color.GRAY);
        graphics.setColor(Color.RED);
        graphics.drawString("Amount of view of this servlet: " + number + " generally", 100, 100);
        ImageIO.write(img, "jpeg", out);
        counter.writeInt(number);
    }
}
