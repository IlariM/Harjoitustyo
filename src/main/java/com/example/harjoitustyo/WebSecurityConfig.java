package com.example.harjoitustyo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
@Override
protected void configure(HttpSecurity http) throws Exception{
	http
		.authorizeRequests()
			.antMatchers("/", "/etusivu").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/omatelokuvat")
			.permitAll()
			.and()
		.logout()
			.permitAll();
			
}

@Bean
@Override
public UserDetailsService userDetailsService() {
    @SuppressWarnings("deprecation")
	UserDetails user =
         User.withDefaultPasswordEncoder()
            .username("käyttäjä")
            .password("salasana")
            .roles("USER")
            .build();

    return new InMemoryUserDetailsManager(user);
}
}
