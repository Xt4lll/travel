package com.example.travel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()  // Даем доступ к любому запросу без авторизации
                .and()
                .csrf().disable()
                .cors().disable()
                .formLogin().disable()  // Отключить стандартную форму авторизации
                .httpBasic().disable();

        return http.build();
    }

    @Autowired
    @Lazy
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Отключаем настройку аутентификации для тестирования
        // auth.jdbcAuthentication()
        //         .dataSource(dataSource)
        //         .passwordEncoder(NoOpPasswordEncoder.getInstance())
        //         .usersByUsernameQuery("select username, password, active from model_user where username =?")
        //         .authoritiesByUsernameQuery("select u.username, ur.roles from model_user u inner join user_role ur on u.id_user = ur.user_id where u.username=?");
    }
}
