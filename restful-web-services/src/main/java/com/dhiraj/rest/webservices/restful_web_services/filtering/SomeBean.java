package com.dhiraj.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({"value1", "value2"})	// ignore array of fileds (value2, value1) this is static filtering
@JsonFilter("someBeanFilterName")
public class SomeBean {
	
	
	private String field1;
	
//	 @JsonIgnore		// ignore this field (value 2) in response this is static filtering
	private String field2;
	private String field3;
	public SomeBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
	public String getField1() {
		return field1;
	}
	public String getField2() {
		return field2;
	}
	public String getField3() {
		return field3;
	}
	
	

}