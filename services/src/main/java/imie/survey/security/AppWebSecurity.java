package imie.survey.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppWebSecurity extends WebSecurityConfigurerAdapter {
	
	
    @Bean
    public RoleHierarchy roleHierarchy(){
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_WRITER > ROLE_USER");
        return roleHierarchy;
    }

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		/*http.formLogin().loginPage("/login")
						.loginProcessingUrl("/login.do")
						.usernameParameter("user")
						.passwordParameter("pass");
		http.authorizeRequests()
			.antMatchers("/**").authenticated()
			.antMatchers("/login").permitAll();
		*/
		//http.addFilterAfter(new CustomFilter() , afterFilter)
		http.authorizeRequests().antMatchers("/**").permitAll();
		/*http
	        .authorizeRequests()
	        	.antMatchers("/login/**").permitAll()
	            .anyRequest().authenticated()
	            .and()
	        .formLogin()
	            .loginPage("/login")
	            .loginProcessingUrl("/login.do")
	            .permitAll()
	            .and()
	        .logout()
	            .permitAll();*/
	}
	
	/**
     * Service d'authentification
     */
   /* @Autowired
    private AuthClientService authClientService;*/

    /**
     * Surcharge de la configuration
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception
    {
        //auth.userDetailsService(authClientService).passwordEncoder(new BCryptPasswordEncoder());
    	auth.inMemoryAuthentication().withUser("user").password("pass").roles("USER");
    }



}
