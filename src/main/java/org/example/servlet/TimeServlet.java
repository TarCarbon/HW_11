package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(value = "/time")
public class TimeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String timezone = req.getParameter("timezone");
        String correctTimezone = timezone.strip().replaceAll(" ", "+");

            String  initTime = LocalDateTime.now(ZoneId.of(correctTimezone)).toString();
            String htmlResponse = "<h1>" + initTime + "</h1>";
            resp.getWriter().println(htmlResponse);

        resp.getWriter().flush();
        resp.getWriter().close();
    }
}
