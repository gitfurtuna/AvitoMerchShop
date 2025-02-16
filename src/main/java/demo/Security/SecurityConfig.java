package demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/api/info").authenticated()
                        .requestMatchers("/api/sendCoin").authenticated()
                        .requestMatchers("/api/buy/**").authenticated()
                )
                .formLogin(formLogin -> formLogin.permitAll())
                .logout(logout -> logout.permitAll())
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> {
                    System.out.println("Access denied to: " + request.getRequestURI());
                    response.sendRedirect("/api/auth/register");
                });
//                )
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                );

        return http.build();
    }
}
