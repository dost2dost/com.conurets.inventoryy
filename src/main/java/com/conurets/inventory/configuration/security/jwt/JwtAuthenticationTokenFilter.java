package com.conurets.inventory.configuration.security.jwt;

import com.conurets.inventory.bean.ErrorResponse;
import com.conurets.inventory.exception.JwtTokenException;
import com.conurets.inventory.service.CustomUserDetailsService;
import com.conurets.inventory.util.InventoryHelper;
import com.conurets.inventory.util.InventoryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author MSA
 */

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Autowired
    private JwtTokenFactory jwtTokenFactory;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    /**
     * Checking @Autowired object
     */

    @PostConstruct
    public void checkConfiguration() {
        InventoryHelper.checkConfiguration(customUserDetailsService, "customUserDetailsService");
        InventoryHelper.checkConfiguration(jwtTokenFactory, "jwtTokenFactory");
    }

    /**
     * Verify token and user access
     * @param request
     * @param response
     * @param chain
     * @throws ServletException
     * @throws IOException
     */

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            String jwt = jwtTokenFactory.getJwt(request);

            if (jwt != null && jwtTokenFactory.validateJwtToken(jwt)) {
                String username = jwtTokenFactory.getUserNameFromJwtToken(jwt);
                
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication
                        = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            chain.doFilter(request, response);
        } catch (JwtTokenException e) {
            logger.error("e: "+ e);
            /*ErrorResponse<Object> exceptionBean = InventoryUtil.setErrorResponse(e.getPosition(), e.getMessage());

            response.setStatus(HttpStatus.OK.value());
            response.getWriter().write(InventoryUtil.writeValue(exceptionBean));
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);*/

            InventoryUtil.setJwtErrorResponse(response, e.getPosition(), e.getMessage());
        }
    }
}