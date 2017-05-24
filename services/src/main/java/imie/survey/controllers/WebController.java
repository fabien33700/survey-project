package imie.survey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	
	@RequestMapping(value = "/login")
	public String login() {
		return "/static/login/index.html";
	}
	
	@RequestMapping(value = "/")
	public String index() {
		return "/index.html";
	}
	
	
}
