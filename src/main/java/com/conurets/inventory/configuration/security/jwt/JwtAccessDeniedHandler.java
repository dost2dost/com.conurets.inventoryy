package com.conurets.inventory.configuration.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author MSA
 */

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    private static final Logger logger = LoggerFactory.getLogger(JwtAccessDeniedHandler.class);

    /**
     * Exception handling
     * @param request
     * @param response
     * @param arg2
     * @throws IOException
     * @throws ServletException
     */

    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException arg2)
            throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, arg2.getMessage());
    }
}