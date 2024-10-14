package com.dhiraj.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


// fire queries to the database using jdbc
@Repository
public class CourseJdbcRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	// sql query
//	private static String INSERT_QUERY=
//			"""
//				insert into course (id, name, author)
//				values (1, 'AWS', 'dhiraj');
//			""";
	
	private static String INSERT_QUERY=
			"""
				insert into course (id, name, author)
				values (?, ?, ?);
			""";
	
	public void insert(CourseJDBC course) {
		// update method can be use to insert, delete and update
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	public static String DELETE_QUERY = 
			"""
				delete from course
				where id = ?;
			""";
	
	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
	
	public static String SELECT_QUERY = 
			"""
				select * from course
				where id = ?;
			""";
	
	// need to have setters to run it successfully
	public CourseJDBC findById(long id) {
		// Result set -> Bean -> Row Mapper
		// it will convert maps rows to java object
		// queryForObject --> guranateed it will be a single row that's why used
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(CourseJDBC.class), id);
	}
	
}
