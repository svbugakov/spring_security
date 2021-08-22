package com.example.producingwebservice;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity(debug = true)
public class ConfigSecur extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/auth/**").authenticated()
                .antMatchers("/adminka/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .and()
                .logout().logoutSuccessUrl("/greeting");
    }

    @Bean
    public UserDetailsService users() {
        final UserDetails user = User.builder()
                .username("soul")
                .password("{bcrypt}$2a$12$uEUHaRvNKp81hJZkSOvVZOG0OzR87XEiJqTUAJPjjj7n8OqzYs.z6") //soul
                .roles("USER")
                .build();

        final UserDetails userAdmin = User.builder()
                .username("admin")
                .password("{bcrypt}$2a$12$uEUHaRvNKp81hJZkSOvVZOG0OzR87XEiJqTUAJPjjj7n8OqzYs.z6") //soul
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, userAdmin);
    }

}
