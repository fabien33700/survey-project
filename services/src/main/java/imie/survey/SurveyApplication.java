package imie.survey;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import imie.survey.security.ApplicationSecurity;

//import imie.survey.security.ApplicationSecurity;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class SurveyApplication {
	
	@Bean
	public WebSecurityConfigurerAdapter webSecurityConfigurationAdapter() {
		return new ApplicationSecurity();
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SurveyApplication.class, args);
	}
}
