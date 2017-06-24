package com.ljy.xml_work.controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by 刘剑银 on 2017/6/23.
 */
@WebServlet("/getCode")
public class AuthCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedImage bufferedImage = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();

        g.setColor(new Color(0,0,0));
        g.drawRect(0,0,99,29);

        g.setColor(new Color(173,216,230));
        g.fillRect(1, 1, 98, 28);

        String code = "";
        String rcode = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int temp = random.nextInt(10);
            code += temp + " ";
            rcode += temp;
        }

        HttpSession session = req.getSession();
        session.setAttribute("code",rcode);

        g.setColor(new Color(255,20,147));

        g.setFont(new Font("宋体",Font.BOLD,22));

        g.drawString(code, 10, 25);

        ImageIO.write(bufferedImage, "jpg", resp.getOutputStream());
    }
}
