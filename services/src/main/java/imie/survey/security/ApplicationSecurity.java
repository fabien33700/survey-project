package imie.survey.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	public ApplicationSecurity() {
		// TODO Auto-generated constructor stub
	}

	public ApplicationSecurity(boolean disableDefaults) {
		super(disableDefaults);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/rest/**").authenticated();
		http.csrf().disable();
		/*http.exceptionHandling().authenticationEntryPoint(new );
		http.formLogin().successHandler();
		http.formLogin().failureHandler(authenticationFailureHandler);*/
	}

}
