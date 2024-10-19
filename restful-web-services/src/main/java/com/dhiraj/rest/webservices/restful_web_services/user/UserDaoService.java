package com.dhiraj.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class UserDaoService {
	// jpa/hibernate --> db's, will connect it
	
	// to perform operation on a database we create a Dao object
	
	private static int usersCount;
	
	private static List<User> users = new ArrayList<>();
	static {
		users.add(new User(++usersCount, "Dhiraj", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "Rohit", LocalDate.now().minusYears(40)));
		users.add(new User(++usersCount, "Harshal", LocalDate.now().minusYears(50)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		users.removeIf(predicate);
	}

	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.stream().filter(predicate).findFirst().orElse(null);
	}	
}
