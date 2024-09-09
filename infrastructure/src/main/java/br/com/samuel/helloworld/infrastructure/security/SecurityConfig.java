//package br.com.samuel.helloworld.infrastructure.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((authz) -> authz
//                        .requestMatchers(new AntPathRequestMatcher("/actuator/**"))
//                        .hasRole("ADMIN")
//                        .anyRequest()
//                        .authenticated()
//                )
//                .httpBasic(withDefaults());
//
//        return http.build();
//    }
//
//}