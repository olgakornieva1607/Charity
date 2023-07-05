package pl.coderslab.charity.config;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import pl.coderslab.charity.service.CustomAuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) throws Exception {

        http.authorizeHttpRequests((authorize) -> authorize
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()

        );
        http
                .authorizeHttpRequests((requests) -> requests
                                .requestMatchers("/", "/registration", "admin/new").permitAll()
                                .requestMatchers("/admin/*").hasRole("ADMIN")
                                .requestMatchers("/resources/images/**","/resources/js/**",
                                        "/resources/css/**", "/WEB-INF/views/header.jsp",
                                        "/WEB-INF/views/loginHeader.jsp","/WEB-INF/views/footer.jsp").permitAll()
                                .anyRequest().authenticated()


                )
                .formLogin((form) -> form
                        .loginPage("/login").successHandler(customAuthenticationSuccessHandler)
                        .permitAll()
                )
                .logout((logout) -> logout.logoutUrl("/logout").permitAll());

        return http.build();
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
