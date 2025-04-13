package org.testingTool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.core.annotation.Order;
import org.testingTool.services.MyAdminDetailsService;
import org.testingTool.services.MyGuestDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  @Bean
  @Order(1)
  public SecurityFilterChain internalSecurityFilterChain(HttpSecurity http) throws Exception {
    return http
        .csrf((csrf) -> csrf
            .csrfTokenRepository(new HttpSessionCsrfTokenRepository())
            .ignoringRequestMatchers("/app-controller/**"))
        .securityMatcher("/admin/**")
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/app-controller/**").hasRole("ADMIN")
            .anyRequest().hasRole("ADMIN"))
        .formLogin(login -> login
            .loginPage("/admin/login")
            .loginProcessingUrl("/admin/login")
            .defaultSuccessUrl("/admin/")
            .permitAll())
        .authenticationProvider(adminAuthenticationProvider())
        .build();
  }

  @Bean
  @Order(2)
  public SecurityFilterChain externalFilterChain(HttpSecurity http) throws Exception {
    return http
        .csrf((csrf) -> csrf
            .csrfTokenRepository(new HttpSessionCsrfTokenRepository()))
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/guest/**").hasRole("USER")
            .requestMatchers("/**").permitAll()
            .anyRequest().authenticated())
        .formLogin(login -> login
            .loginPage("/login")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/guest/")
            .permitAll())
        .authenticationProvider(guestAuthenticationProvider())
        .build();
  }

  @Bean
  public AuthenticationProvider adminAuthenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(adminDetailsService());
    provider.setPasswordEncoder(passwordEncoder());
    return provider;
  }

  @Bean
  public AuthenticationProvider guestAuthenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(guestDetailsService());
    provider.setPasswordEncoder(passwordEncoder());
    return provider;
  }

  @Bean
  public UserDetailsService adminDetailsService() {
    return new MyAdminDetailsService();
  }

  @Bean
  public UserDetailsService guestDetailsService() {
    return new MyGuestDetailsService();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
