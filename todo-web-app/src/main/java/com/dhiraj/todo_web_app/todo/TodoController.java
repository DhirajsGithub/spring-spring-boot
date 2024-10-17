package com.dhiraj.todo_web_app.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
// by this session attribute name will be available in model as well
public class TodoController {
	
	private TodoService todoService;
	
	// constructor autowiring
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUsername(getLoggedInUsername());
		model.put("todos", todos);
		return "listTodos";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedInUsername();
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		// coz we are binding Todo directly to the form in todo.jsp
		// this is one side binding, we are binding jsp tags with the todocontroller
		// from controller to values showing in the form
		return "todo";
	}
	
	// redirect will be path name as redirect:path-name
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String redirectToTodoList(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username = getLoggedInUsername();
		todoService.addTodo(username, todo.getDescription(), todo.gettargetDate(), false);
		// this is second side binding 
		// from form to controller
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String updateTodo(@RequestParam int id, ModelMap model) {
		String username = getLoggedInUsername();
		Todo todo = todoService.findById(id);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodoAndRedirect(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username = getLoggedInUsername();
		todo.setUsername(username);
		todoService.updateTodo(todo);
		// this is second side binding 
		// from form to controller
		return "redirect:list-todos";
	}
	
	private String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}









