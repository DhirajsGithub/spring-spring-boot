package com.dhiraj.todo_web_app.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String name, String password) {
		return name.equalsIgnoreCase("dhiraj") && password.equalsIgnoreCase("rand");
	}
}
