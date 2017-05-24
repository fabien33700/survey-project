package imie.survey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import imie.survey.configuration.AppWebConfig;
import imie.survey.security.AppWebSecurity;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {
	"imie.survey"
})
@Import({AppWebSecurity.class, AppWebConfig.class})
public class SurveyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyApplication.class, args);
	}
}
