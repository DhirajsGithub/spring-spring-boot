package com.dhiraj.todo_web_app.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")		
// name of attribute to put it in session
// name attribute we put it in model we additional want to put it in session
// use the @SessionAttributes("name") to all controller where that controller jsp is using name 
// by default anything you put in model is in request scope, you can add it in session scope with help of session attribute
public class LoginController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String goToLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String goToWelcomPage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		
		if(authenticationService.authenticate(name, password)) {
			model.put("name", name);
			model.put("password", password);
			return "welcome";
		}
		
		model.put("errorMessage", "Invalid credentials");
		return "login";
	}
	


}
