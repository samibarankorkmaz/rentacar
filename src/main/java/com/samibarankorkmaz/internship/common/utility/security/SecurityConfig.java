//package com.samibarankorkmaz.internship.common.utility.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.*;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(request -> request
//                        .requestMatchers(HttpMethod.GET, "/rentacar/brands/**", "/rentacar/models/**", "/rentacar/cars/**")
//                        .hasRole("CUSTOMER")
//                        .requestMatchers(HttpMethod.POST, "/rentacar/rentals/create")
//                        .hasRole("CUSTOMER")
//                        .requestMatchers(HttpMethod.POST, "/rentacar/brands/create", "/rentacar/brands/createBulk")
//                        .hasRole("L0-ADMIN")
//                        .requestMatchers(HttpMethod.PATCH, "/rentacar/brands/patch-by-parent-company/{parentCompany}")
//                        .hasRole("L0-ADMIN")
//                )
//                .csrf(AbstractHttpConfigurer::disable)
//                .build();
//    }
//
//    @Bean
//    UserDetailsService testOnlyUsers(PasswordEncoder passwordEncoder) {
//        User.UserBuilder users = User.builder();
//        UserDetails samibarankorkmaz = users
//                .username("sb_korkmaz")
//                .password(passwordEncoder.encode("sbk123456"))
//                .roles("CUSTOMER")
//                .build();
//        UserDetails admin = users
//                .username("mr_robot")
//                .password(passwordEncoder.encode("admin_MrRobot_42"))
//                .roles("L0-ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(samibarankorkmaz);
//    }
//
//}
