package app.edumanager.configurations.Fillters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import app.edumanager.services.AuthService;
import app.edumanager.services.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private AuthService authService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                var authToken = request.getHeader("Authorization");

                if (authToken != null) {
                    var aToken = authToken.replace("Bearer ", "");

                   var anUsername =  authService.validate(aToken);

                   var anUser = customUserDetailsService.loadUserByUsername(anUsername);

                   var auth =  new UsernamePasswordAuthenticationToken(anUser, null,  anUser.getAuthorities());

                   SecurityContextHolder.getContext().setAuthentication(auth);;

                }

                filterChain.doFilter(request, response);

    }
    
}