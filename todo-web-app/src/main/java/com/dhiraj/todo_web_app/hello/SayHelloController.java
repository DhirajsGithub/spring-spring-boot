package com.dhiraj.todo_web_app.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	
	// http://localhost:8080/say-hello
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hellow from the other side !!!";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My First HTML Page - Changed</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1>");
		sb.append("My first html page with body - Changed");
		sb.append("</h1>");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	// this fucntion will not be treated as response body but it will redirect to sayHello.jsp 
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	// this is the folder where it will look up for the jsp's
	// using prefix and suffix in application.properties it determines the full path
	/*
	<dependency>
		<groupId>org.apache.tomcat.embed</groupId>
		<artifactId>tomcat-embed-jasper</artifactId>
		<scope>provided</scope>
	</dependency>
	this dependency is necessary for jsp 
	 */
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
	
	
	
	// http://localhost:8080/login?name=dhiraj
	// Model --> whenever you want to pass anything from your controller to your jsp 
	// put it inside model, with "value name", "any value", and access it in jsp as ${value name}
	@RequestMapping("hello-param")
	public String goToLoginPage(@RequestParam String name, ModelMap model) {
		logger.debug("Request param is debug level {}", name);
		logger.info("Request param is info level {}", name);
		logger.warn("Request param is warn level {}", name);
		model.put("name", name);
		return "sayHello";
	}
	
	@RequestMapping("/hello-path/{myCode}")
	@ResponseBody
	public String getHelloByCode(@PathVariable String myCode) {
	    // Here, myCode will capture the value passed in the URL (e.g., "code")
	    return "Received code: " + myCode;
	}
	

}







