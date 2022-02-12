package com.example.Portfolio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.Portfolio.service.MyUserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private MyUserService userService;
	
	@Autowired
	public WebSecurityConfig (MyUserService userService) {
		this.userService = userService;
	}
	// 静的ファイルをはじかないようにしている
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/js/**","/css/**","/images/**");
	}
	// URLパス毎に制御
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
				.antMatchers("/h2-console/","/portfolio","/portfolio/about_me","/portfolio/books","/portfolio/product","/portfolio/loginForm").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
			.loginPage("/portfolio/loginForm")
			.loginProcessingUrl("/login")
			.usernameParameter("username")
			.passwordParameter("password")
			.defaultSuccessUrl("/portfolio", true)
			.failureUrl("/portfolio/loginForm?error=true");
	}
	
	// ユーザー情報の取得
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}
	
	// パスワードハッシュ化する
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		return bcpe;
	}
	
}
