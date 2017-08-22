package imie.survey.security;
 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import imie.survey.security.jwt.JWTAuthenticationFilter;
import imie.survey.security.jwt.JWTLoginFilter;
 
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
	
	@Value("${survey.options.disable-security}")
	private Boolean disableSecurity;
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		if (disableSecurity) {
			http.csrf()
				.disable()
				.authorizeRequests()
				.anyRequest()
				.permitAll();
		} else {
			http.csrf()
				.disable()
				.authorizeRequests()
			    .antMatchers("/").permitAll()
			    .antMatchers("/static/**").permitAll()
			    .antMatchers(HttpMethod.POST, "/login").permitAll()
			    .anyRequest().authenticated()
			    .and()
			
			    .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
			            UsernamePasswordAuthenticationFilter.class)
			    .addFilterBefore(new JWTAuthenticationFilter(),
			            UsernamePasswordAuthenticationFilter.class);
		}
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	    	.withUser("admin")
	    	.password("password")
	    	.roles("ADMIN");
	}
}