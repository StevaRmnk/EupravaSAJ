//package com.example.Gradjanin.Security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.headers().frameOptions().disable()
//                .and()
//                .authorizeRequests()
//                .antMatchers( "*").permitAll()
//                .antMatchers(HttpMethod.GET, "*").permitAll()
//                .antMatchers(HttpMethod.POST, "*").permitAll()
//                .antMatchers(HttpMethod.PUT, "*").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/*").permitAll()
//                .antMatchers(HttpMethod.OPTIONS, "*").permitAll()
//                .anyRequest().authenticated().and().cors().configurationSource(corsConfigurationSource());
//
//
//
//        //DODATO BUSINESREGISTER
//    }
//}