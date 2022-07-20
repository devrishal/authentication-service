package com.rds.utility.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.rds.utility.AuthenticationServiceException;
import com.rds.utility.common.ApplicationConstant;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;

@Component
public class JWTAuthorisationFilter extends BasicAuthenticationFilter {

    private final RSAPrivateKey privateKey;
    private final RSAPublicKey publicKey;

    public JWTAuthorisationFilter(AuthenticationManager authenticationManager, RSAPrivateKey privateKey, RSAPublicKey publicKey) {
        super(authenticationManager);
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(ApplicationConstant.AUTHORIZATION);
        if (header == null || !header.startsWith(ApplicationConstant.BEARER)) {
            chain.doFilter(request,response);
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(request);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request,response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(ApplicationConstant.AUTHORIZATION);
        if (token != null) {
            token = token.replace(ApplicationConstant.BEARER, ApplicationConstant.EMPTY_STRING);
            String user = JWT.require(Algorithm.RSA256(publicKey, privateKey)).build().verify(token).getSubject();
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            throw new AuthenticationServiceException("Invalid Token");
        }
        throw new AuthenticationServiceException("Invalid Token");
    }
}
