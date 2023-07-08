package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails kushal = User.builder()
                .username("kushal")
                .password("{noop}kushal1")
                .roles("EMPLOYEE")
                .build();
        UserDetails kushal1 = User.builder()
                .username("kushal1")
                .password("{noop}kushal1")
                .roles("EMPLOYEE", "MANAGER")
                .build();
        UserDetails kushal2 = User.builder()
                .username("kushal2")
                .password("{noop}kushal2")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(kushal, kushal1, kushal2);
    }

     */
    //adding support for users saved in JDBC hence commenting above hard coded solution

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        //as we have followed the spring security format of creating users and authorities table in our DB
        // that will automatically be read

        //below lines added as now I have added personal tables for user and roles
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        //define query to retrieve user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        //define query to retrieve the authorities/role by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
        return jdbcUserDetailsManager;
    }
    //bcrypt pass is fun123
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );
        //use basic authentication
        http.httpBasic(Customizer.withDefaults());
        //disable csrf
        //in general not required for stateless rest api's that use post put delete and/or patch
        http.csrf().disable();
        return http.build();
    }
}
