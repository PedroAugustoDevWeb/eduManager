package app.edumanager.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import app.edumanager.configurations.Fillters.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private JwtAuthenticationFilter authenticationFilter;

    @Bean
    public SecurityFilterChain setSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                    .csrf(csrf -> csrf.disable())
                    .sessionManagement(session -> 
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authorizeHttpRequests(authorize ->
                        authorize.requestMatchers("api/auth/**").permitAll()
                        .requestMatchers("api/**").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()  
                    )
                    .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                    .build();

    }

}
