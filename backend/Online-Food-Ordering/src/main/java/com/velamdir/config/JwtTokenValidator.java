package com.velamdir.config;

import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JwtTokenValidator extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String jwt=request.getHeader(JwtConstant.JWT_HEADER);

        //Bearer token
        if(jwt != null){
            jwt = jwt.substring(7);
            try{
                SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
            }catch(Exception e) {
                throw new BadCredentialsException("invalid token......");
            }
        }
        filterChain.doFilter(request,response);
    }
}
