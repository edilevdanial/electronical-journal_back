//package com.example.intc_backend.config;
//
//import com.example.intc_backend.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Optional;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
//    private final UserRepository userRepository;
//    private final JwtTokenFilter jwtTokenFilter;
//
//    @Autowired
//    public WebSecurityConfig(
//            UserRepository userRepository
//    ) {
//        this.userRepository = userRepository;
//    }
//
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//
////        registry.addMapping("/api/**")
////                .allowedOrigins("http://localhost:8084/")
////                .allowedMethods("*");
//    }
//
////    @Bean
////    CorsConfigurationSource corsConfigurationSource() {
////        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
//////        corsConfiguration.addAllowedOrigin("http://localhost:8084/");
////        source.registerCorsConfiguration("/**", corsConfiguration);
////        return source;
////    }
//
//
////.configurationSource(request -> new CorsConfiguration().addAllowedOrigin("http://localhost:8084/"))
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
////        http.cors().and()
////                .authorizeRequests()
////                .antMatchers("/home").permitAll()
////                .antMatchers("/api/auth/**").permitAll()
////                .antMatchers("/auth/**").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .logout()
////                .permitAll();
//
//
////        http.cors()
////                .and()
////                .authorizeRequests()
////                .antMatchers(HttpMethod.GET, "/user/info", "/api/foos/**")
////                .hasAuthority("SCOPE_read")
////                .antMatchers(HttpMethod.POST, "/api/foos")
////                .hasAuthority("SCOPE_write")
////                .anyRequest()
////                .authenticated()
////                .and()
////                .oauth2ResourceServer()
////                .jwt();
//
//    }
//
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // TODO configure authentication manager
//        auth.userDetailsService(username -> Optional.ofNullable(userRepository.findByPhoneNumber(username))
//                .map(user -> new UserDetails() {
//                    @Override
//                    public Collection<? extends GrantedAuthority> getAuthorities() {
//                        return Collections.emptyList();
//                    }
//
//                    @Override
//                    public String getPassword() {
//                        return user.getPassword();
//                    }
//
//                    @Override
//                    public String getUsername() {
//                        return user.getPhoneNumber();
//                    }
//
//                    @Override
//                    public boolean isAccountNonExpired() {
//                        return true;
//                    }
//
//                    @Override
//                    public boolean isAccountNonLocked() {
//                        return true;
//                    }
//
//                    @Override
//                    public boolean isCredentialsNonExpired() {
//                        return true;
//                    }
//
//                    @Override
//                    public boolean isEnabled() {
//                        return true;
//                    }
//                })
//                .orElseThrow(
//                        () -> new RuntimeException(
//                                String.format("User: %s, not found", username)
//                        )
//                ));
//    }
//
////    @Bean
////    @Override
////    public UserDetailsService userDetailsService() {
////        UserDetails user =
////                User.withDefaultPasswordEncoder()
////                        .username("u")
////                        .password("p")
////                        .roles("STUDENT")
////                        .build();
////
////        return new InMemoryUserDetailsManager(user);
////    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}