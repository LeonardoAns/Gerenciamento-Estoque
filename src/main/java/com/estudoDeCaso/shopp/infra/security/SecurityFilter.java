package com.estudoDeCaso.shopp.infra.security;

import com.estudoDeCaso.shopp.useCases.jwt.ValidateTokenUseCase;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private ValidateTokenUseCase validateTokenUseCase;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);
        if(token != null) {
            try {
                var login = validateTokenUseCase.validateToken(token);

                if (login != null) {
                    UserDetails userDetails = userDetailsService.loadUserByUsername(login);

                    Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    System.out.println(userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }catch (Exception exception){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
        filterChain.doFilter(request,response);
    }

    private String recoverToken(HttpServletRequest request){
        var authReader = request.getHeader("Authorization");
        if(authReader == null) return null;
        return authReader.replace("Bearer ","");
    }
}
