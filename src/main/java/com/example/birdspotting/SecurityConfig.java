package com.example.birdspotting;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{			
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
			.withUser("spotter").password(encoder.encode("redDuck007")).roles("SPOTTER").and()
			.withUser("admin").password(encoder.encode("eagle")).roles("SPOTTER", "ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		http.formLogin().
			defaultSuccessUrl("/birdspotting", true)
			.loginPage("/login");
		http.authorizeRequests()
			.antMatchers("/birdspotting/*/newbirdspotting").hasRole("ADMIN")
			.antMatchers("/birdspotting/**").hasRole("SPOTTER")
			.and()
			.exceptionHandling().accessDeniedPage("/403");
	}
}
