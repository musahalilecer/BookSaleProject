package com.musahalilecer.booksaleproject.security;


import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    public final UserDetailsService userDetailsService;

    public SecurityConfig(final JwtAuthenticationFilter jwtAuthenticationFilter, final UserDetailsService userDetailsService) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(withDefaults())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()  // ✅ REGISTER & LOGIN AÇIK
                        .requestMatchers("/user/**").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/book/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/book/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/book/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/book/**").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/author/**").hasRole("USER")

                        .requestMatchers(HttpMethod.POST, "/author/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/author/**").hasRole("USER")

                        .requestMatchers(HttpMethod.GET, "/language/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/language/**").hasRole("USER")

                        .requestMatchers(HttpMethod.GET, "/publisher/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/publisher/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/publisher/**").hasRole("USER")

                        .requestMatchers(HttpMethod.GET, "/country/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/country/**").hasRole("USER")

                        .requestMatchers(HttpMethod.GET, "customer/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "customer/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "customer/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "customer/**").hasRole("USER")
                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    /*
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
     */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}


