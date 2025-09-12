package com.aarish.PwdGenerator.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

import java.io.IOException;

@Configuration
public class SecurityConfig {

    @Bean
    public FilterRegistrationBean<SecurityHeadersFilter> securityHeadersFilter() {
        FilterRegistrationBean<SecurityHeadersFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new SecurityHeadersFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    public static class SecurityHeadersFilter implements Filter {
        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {
            
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            
            // Content Security Policy - More permissive for React app
            httpResponse.setHeader("Content-Security-Policy", 
                "default-src 'self'; script-src 'self' 'unsafe-inline' 'unsafe-eval'; style-src 'self' 'unsafe-inline'; img-src 'self' data: blob:; connect-src 'self' https://password-generator-backend-production-0581.up.railway.app http://localhost:8080 http://localhost:3000; font-src 'self' data:");
            
            // Referrer Policy
            httpResponse.setHeader("Referrer-Policy", "strict-origin-when-cross-origin");
            
            // Frame Options
            httpResponse.setHeader("X-Frame-Options", "DENY");
            
            // Content Type Options
            httpResponse.setHeader("X-Content-Type-Options", "nosniff");
            
            chain.doFilter(request, response);
        }
    }
}