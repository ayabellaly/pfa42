package com.example.cabinetdentistspring.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/registration/**").permitAll()
                        .requestMatchers("/login/**").permitAll()
                        .requestMatchers("/user/**").permitAll()
                        .requestMatchers("/admin/**").permitAll()
                        .requestMatchers("/allpatient").hasAnyAuthority("Medecin","Secretaire")
                        .requestMatchers("/Acceuil").permitAll()
                        .requestMatchers("/Index-Secretaire").hasAnyAuthority("Secretaire")
                        .requestMatchers("/Index-Medecin").hasAnyAuthority("Medecin")
                        .requestMatchers("/allPrescription").hasAnyAuthority("Medecin")
                        .requestMatchers("/allEvent").hasAnyAuthority("Secretaire","Medecin")
                        .requestMatchers("/addEvent").hasAnyAuthority("Secretaire","Medecin")
                        .requestMatchers("/addPrescription").hasAnyAuthority("Medecin")



                        .requestMatchers("/static/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/Acceuil",true)
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll())
                .exceptionHandling().accessDeniedPage("/access-denied");
        return http.build();
    }
}