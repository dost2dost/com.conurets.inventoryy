package com.conurets.inventory.filter;

import com.conurets.inventory.model.CustomUserDetails;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryHelper;
import com.conurets.inventory.util.InventoryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author MSA
 */

@Component
public class AuthenticationFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String authorizationHeader = httpServletRequest.getHeader(InventoryConstants.AUTHORIZATION);

        if (authorizationHeader != null) {
            CustomUserDetails customUserDetails = InventoryUtil.getUserDetails();

            InventoryHelper.validateSession(customUserDetails);
        }

        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}