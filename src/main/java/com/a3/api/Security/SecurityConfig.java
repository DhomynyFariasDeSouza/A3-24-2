package com.a3.api.Security;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    UserAuthenticationFilter uAuthenticationF;

    public static final String [] ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED = {
        "/users/login",
        "/users",
        "/itens"
};

    public static final String [] ENDPOINT_ADM_GET = {
        "/user/",
    };

    public static final String [] ENDPOINT_ADM_POST = {
        "/itens/","/user" 
    };

    public static final String [] ENDPOINT_ADM_DELETE = {
        "/itens/","/user/"
    };

    public static final String [] ENDPOINT_ADM_PUT = {
        "/itens/","/user/"
    };


    @SuppressWarnings({ "removal", "deprecation" })
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
       return http.csrf().disable()
       .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
       .and().authorizeRequests()
            .requestMatchers(ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED).permitAll()
            .requestMatchers(HttpMethod.GET,ENDPOINT_ADM_GET).hasRole("ADMINISTRACAO")
            .requestMatchers(HttpMethod.POST,ENDPOINT_ADM_POST).hasRole("ADMINISTRACAO")
            .requestMatchers(HttpMethod.DELETE,ENDPOINT_ADM_DELETE).hasRole("ADMINISTRACAO")
            .requestMatchers(HttpMethod.PUT,ENDPOINT_ADM_PUT).hasRole("ADMINISTRACAO")
            .anyRequest().denyAll()
            .and().addFilterBefore(uAuthenticationF,UsernamePasswordAuthenticationFilter.class).build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
