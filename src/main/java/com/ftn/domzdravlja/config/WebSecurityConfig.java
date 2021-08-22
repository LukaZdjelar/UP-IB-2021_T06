package com.ftn.domzdravlja.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.ftn.domzdravlja.security.TokenAuthenticationFilter;
import com.ftn.domzdravlja.security.TokenHelper;
import com.ftn.domzdravlja.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private CustomUserDetailService jwtUserDetailsService;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Autowired
	TokenHelper tokenHelper;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
				.authenticationEntryPoint((request, response, ex) -> {
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
				}).and().authorizeRequests().antMatchers("/domZdravlja/ao/**").permitAll()
				.antMatchers(HttpMethod.POST, "/admin").permitAll()
				.antMatchers(HttpMethod.POST, "PUTANJE KOJE SVI MOGU").permitAll()
				.antMatchers(HttpMethod.PUT, "/admin/edit").permitAll()
				.antMatchers(HttpMethod.GET, "PUTANJE KOJE SVI MOGU").permitAll().anyRequest().authenticated().and()
				.addFilterBefore(new TokenAuthenticationFilter(tokenHelper, jwtUserDetailsService),
						BasicAuthenticationFilter.class)

				.csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.POST, "/api/auth/login", "/api/admin", "/api/tags/add/**",
				"/api/users/image"

		);
		web.ignoring().antMatchers(HttpMethod.PUT, "/api/users/role/**");
		web.ignoring().antMatchers(HttpMethod.GET, "/", "/webjars/**", "/*.html", "/favicon.ico", "/**/*.html",
				"/**/*.css", "/**/*.js", "/api/posts/**", "/api/comments/**", "/api/users/allUsername",
				"/api/get/role/**", "/api/posts/order/**", "/api/comments/post/order/**", "/api/posts/search/**");

	}

}
