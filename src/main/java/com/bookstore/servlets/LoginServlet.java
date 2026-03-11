package com.bookstore.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Read raw request body (assume {"username":"...","password":"..."})
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) sb.append(line);

        String body = sb.toString().trim();
        String username = null, password = null;

        if (body.startsWith("{") && body.endsWith("}")) {
            body = body.substring(1, body.length() - 1);
            String[] pairs = body.split(",");
            for (String pair : pairs) {
                String[] kv = pair.split(":");
                if (kv.length == 2) {
                    String key = kv[0].trim().replace("\"", "");
                    String value = kv[1].trim().replace("\"", "");
                    if ("username".equals(key)) username = value;
                    if ("password".equals(key)) password = value;
                }
            }
        }

        if (username == null || password == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"error\":\"Username or password missing\"}");
            return;
        }

        // Here you would validate username/password with DB
        // For example purpose, accept only "admin" / "password123"
        if (!"admin".equals(username) || !"password123".equals(password)) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().write("{\"error\":\"Invalid credentials\"}");
            return;
        }

        // Generate code/token
        String code = UUID.randomUUID().toString();

        // Store in ServletContext
        Map<String, String> codeMap = (Map<String, String>) getServletContext().getAttribute("AUTH_CODES");
        if (codeMap == null) {
            codeMap = new ConcurrentHashMap<>();
            getServletContext().setAttribute("AUTH_CODES", codeMap);
        }
        codeMap.put(code, username); // Map code -> username

        // Return code to client
        resp.setContentType("application/json");
        resp.getWriter().write("{\"code\":\"" + code + "\"}");
    }
}