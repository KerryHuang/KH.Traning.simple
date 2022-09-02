package com.soetek.simple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/", "/webjars/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login();
//                .formLogin()
//                .and()
//                .httpBasic(withDefaults());

        return http.build();
    }

    // 參考
    // https://spring.io/guides/tutorials/spring-boot-oauth2/
    // https://medium.com/swlh/spring-boot-oauth2-login-with-github-88b178e0c004

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/hello", "/", "/webjars/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }*/
}
