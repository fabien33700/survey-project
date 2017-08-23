package imie.survey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import imie.survey.security.ApplicationSecurity;


@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class SurveyApplication {

	/**
	 * TODO A verifier
	 * @return
	 */
	/*@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
        	final static String DEVSERVER_URI = "http://localhost:9000";
        	
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")  .allowedOrigins(DEVSERVER_URI);
            }
        };
    }*/
	
	@Bean
	public WebSecurityConfigurerAdapter webSecurityConfigurationAdapter() {
		return new ApplicationSecurity();
	}

	public static void main(String[] args) {
		SpringApplication.run(SurveyApplication.class, args);
	}
}
