package com.finaly.projectback.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@ConfigurationProperties("spring.datasource")
	public DataSource ds() {
		return DataSourceBuilder.create().build();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		 .antMatcher("/project")
		.httpBasic().and().authorizeRequests().anyRequest().authenticated();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("test").password("test").roles("USER");
		auth.jdbcAuthentication().dataSource(dataSource)
				.authoritiesByUsernameQuery("select USERNAME, ROLE from web_user where USERNAME=?")
				.usersByUsernameQuery("select USERNAME, web_user.pwd as PASSWORD, 1 as enabled  from web_user where USERNAME=?");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
