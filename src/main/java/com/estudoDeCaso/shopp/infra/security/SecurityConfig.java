package com.estudoDeCaso.shopp.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/employee").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/employee/{id}").hasAuthority("ROLE_MANAGEMENT")
                        .requestMatchers(HttpMethod.GET, "/employee/{id}").hasAuthority("ROLE_MANAGEMENT")
                        .requestMatchers(HttpMethod.GET, "/employees").hasAuthority("ROLE_MANAGEMENT")
                        .requestMatchers(HttpMethod.PUT, "/employee/{id}").hasAuthority("ROLE_MANAGEMENT")
                        // SALE
                        .requestMatchers(HttpMethod.POST, "/category").hasAuthority("ROLE_SALES")
                        .requestMatchers(HttpMethod.DELETE, "/category/{id}").hasAuthority("ROLE_SALES")
                        .requestMatchers(HttpMethod.GET, "/categories").hasAuthority("ROLE_SALES")
                        .requestMatchers(HttpMethod.GET, "/category/{id}").hasAuthority("ROLE_SALES")
                        .requestMatchers(HttpMethod.PUT, "/category/{id}").hasAuthority("ROLE_SALES")
                        .requestMatchers(HttpMethod.POST, "/product").hasAuthority("ROLE_SALES")
                        .requestMatchers(HttpMethod.DELETE, "/product/{id}").hasAuthority("ROLE_SALES")
                        .requestMatchers(HttpMethod.GET, "/product/{id}").hasAuthority("ROLE_SALES")
                        .requestMatchers(HttpMethod.GET, "/products").hasAuthority("ROLE_SALES")
                        .requestMatchers(HttpMethod.PUT, "/product/{id}").hasAuthority("ROLE_SALES")
                        .requestMatchers(HttpMethod.GET, "/product_history").hasAuthority("ROLE_SALES")
                        .requestMatchers(HttpMethod.GET, "/sale/{id}").hasAuthority("ROLE_SALES")
                        .requestMatchers(HttpMethod.POST, "/sales/{id}").hasAuthority("ROLE_SALES")

                        .requestMatchers(HttpMethod.GET, "/product_history").hasAuthority("ROLE_STOCK")
                        .anyRequest().authenticated()
                )

                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_MANAGEMENT > ROLE_SALES \n ROLE_SALES > ROLE_STOCK");
        return roleHierarchy;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
