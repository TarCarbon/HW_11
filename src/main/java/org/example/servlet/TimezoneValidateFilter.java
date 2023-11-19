package org.example.servlet;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(value = "/time/*")
public class TimezoneValidateFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String timezone = req.getParameter("timezone");
        String correctTimezone = timezone.strip().replaceAll(" ", "+");
            if(isValidTimeZone(correctTimezone)) {
                chain.doFilter(req, resp);
            }
            else {
                resp.setStatus(401);
            }
        resp.setContentType("multipart/form-data");
        resp.getWriter().write("{\"Error\" : \"False time format\"}");

    }

    private static boolean isValidTimeZone(String inputStr) {
        String timeZonePattern = "^UTC([+])(?:[0-9]|1[0-9]|2[0-4])$";
        Pattern pattern = Pattern.compile(timeZonePattern);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }
}