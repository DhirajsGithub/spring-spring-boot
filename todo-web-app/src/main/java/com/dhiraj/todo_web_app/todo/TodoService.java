package com.dhiraj.todo_web_app.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount=3;
	static {
		todos.add(new Todo(++todosCount, "in28minutes","Get AWS Certified 1", 
							LocalDate.now().plusYears(1), false ));
		todos.add(new Todo(++todosCount, "in28minutes","Learn DevOps 1", 
				LocalDate.now().plusYears(2), false ));
		todos.add(new Todo(++todosCount, "in28minutes","Learn Full Stack Development 1", 
				LocalDate.now().plusYears(3), false ));
	}
	
	public List<Todo> findByUsername(String username){
		return todos;
	}
	
	public void addTodo(String username, String description, LocalDate localDate, boolean done) {
		Todo todo = new Todo(++todosCount, username, description, localDate, done);
		todos.add(todo);
	}
	
	public void deleteTodo(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		// it will scan all the todos and return a todo which id matches the provided id
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
	    for (Todo todo : todos) {
	        if (todo.getId() == id) {
	            return todo;
	        }
	    }
	    return null; // Return null if no matching Todo is found
	}

	public void updateTodo(Todo todo) {
		// TODO Auto-generated method stub
		deleteTodo(todo.getId());
		todos.add(todo);
		
	}
}
