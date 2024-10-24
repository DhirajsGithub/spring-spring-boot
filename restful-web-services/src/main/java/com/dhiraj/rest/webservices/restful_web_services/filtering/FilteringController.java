package com.dhiraj.rest.webservices.restful_web_services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
//	@GetMapping("/filtering")
//	public SomeBean filtering() {
//		return new SomeBean("value 1", "value 2", "value 3");
//	}
	
//	@GetMapping("/filtering-list")
//	public List<SomeBean> filteringBean() {
//		return Arrays.asList(new SomeBean("value 1", "value 2", "value 3"), new SomeBean("value 4", "value 5", "value 6"));
//	}
	
	// dynamic filtering
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		SomeBean someBean = new SomeBean("value 1", "value 2", "value 3");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilterName", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
	

	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringBean() {
		List<SomeBean> list = Arrays.asList(new SomeBean("value 1", "value 2", "value 3"), new SomeBean("value 4", "value 5", "value 6"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilterName", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
	

}
