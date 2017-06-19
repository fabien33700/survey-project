package imie.survey.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {
	
	@RequestMapping("/api/echo")
	String echo() {
		return "Welcome!";
	}
}
