package com.dhiraj.todo_web_app.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	
	// see the name convention findByFieldName
	public List<Todo> findByUsername(String username);
}
