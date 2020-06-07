package com.scoquix.deepIT.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

public class JwtFilter extends BasicAuthenticationFilter {
    JwtFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        UsernamePasswordAuthenticationToken token = getAuthToken(header);
        SecurityContextHolder.getContext().setAuthentication(token);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthToken(String header) {
        if (header == null || !header.startsWith("Bearer ")) {
            return null;
        } else {
            try {
                Jws<Claims> claims = Jwts.parser().setSigningKey("aaa".getBytes()).parseClaimsJws(header.replace("Bearer ", ""));
                String username = claims.getBody().get("username").toString();
                System.out.println(username);
                String role = claims.getBody().get("role").toString();
                System.out.println(role);
                Set<SimpleGrantedAuthority> authority = Collections.singleton(new SimpleGrantedAuthority(role));
                return new UsernamePasswordAuthenticationToken(username, null, authority);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
