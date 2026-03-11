package com.bookstore.filter;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/api/*")
public class AuthFilter extends HttpFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getRequestURI();

        // Skip login endpoint
		// if (path.endsWith("/api/login")) {
		if (path.contains("/api/")) {
            chain.doFilter(request, response);
            return;
        }

        // Read code from header
        String code = req.getHeader("Authorization");

        if (code == null || code.isEmpty()) {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
         
            return;
        }

        // Get code map from context
        Map<String, String> codeMap = (Map<String, String>) req.getServletContext().getAttribute("v");

        if (codeMap == null || !codeMap.containsKey(code)) {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
           
            return;
        }

        // Code valid → proceed to servlet
        chain.doFilter(request, response);
    }
}