package com.conurets.inventory.configuration.security.jwt;

import com.conurets.inventory.exception.JwtTokenException;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryUtil;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author MSA
 */

@Component
public class JwtTokenFactory {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenFactory.class);

    @Value("${cts.inventory.jwt.secret}")
    private String jwtSecret;
    @Value("${cts.inventory.jwt.expiration}")
    private int jwtExpiration;
    @Value("${cts.inventory.jwt.issuer}")
    private String jwtIssuer;

    /**
     * Generate token on login
     * @param authentication
     * @return token
     */

    public String createJwtToken(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Date expirationDate = new Date((new Date()).getTime() + jwtExpiration * 1000);

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuer(jwtIssuer)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    /**
     * Generate token on login
     * @param username
     * @return token
     */

    public String createJwtToken(String username) {
        Date expirationDate = new Date((new Date()).getTime() + jwtExpiration * 1000);

        return Jwts.builder()
                .setSubject(username)
                .setIssuer(jwtIssuer)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    /**
     * Verify token on every request from client
     * @param authenticationToken
     * @return boolean
     */

    public boolean validateJwtToken(String authenticationToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authenticationToken);
            return Boolean.TRUE;
        } catch (SignatureException e) {
            throw new JwtTokenException(InventoryConstants.STATUS_CODE_JWT_INVALID_SIGNATURE, e.getMessage());
        } catch (MalformedJwtException e) {
            throw new JwtTokenException(InventoryConstants.STATUS_CODE_JWT_MALFORMED, e.getMessage());
        } catch (ExpiredJwtException e) {
            throw new JwtTokenException(InventoryConstants.STATUS_CODE_JWT_EXPIRED, e.getMessage());
        } catch (UnsupportedJwtException e) {
            throw new JwtTokenException(InventoryConstants.STATUS_CODE_JWT_UNSUPPORTED, e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new JwtTokenException(InventoryConstants.STATUS_CODE_JWT_ILLEGAL_ARGUMENT, e.getMessage());
        }
    }

    /**
     * Extract username from token string
     * @param token
     * @return username
     */

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * Extract token from rquest object
     * @param request
     * @return token
     */

    public String getJwt(HttpServletRequest request) {
        String authHeader = request.getHeader(InventoryConstants.AUTHORIZATION);

        if (authHeader != null && authHeader.startsWith(InventoryConstants.AUTHORIZATION_BEARER_SPACE)) {
            return InventoryUtil.decode(authHeader.replace(InventoryConstants.AUTHORIZATION_BEARER_SPACE, InventoryConstants.SC_EMPTY));
        }

        return null;
    }
}