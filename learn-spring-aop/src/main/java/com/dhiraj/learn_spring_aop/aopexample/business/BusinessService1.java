package com.dhiraj.learn_spring_aop.aopexample.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.dhiraj.learn_spring_aop.aopexample.annotations.TrackTime;
import com.dhiraj.learn_spring_aop.aopexample.data.DataService1;

@Service
public class BusinessService1 {
	private DataService1 dataService;
	
	public BusinessService1(DataService1 dataService) {
		this.dataService = dataService;
	}
	
	@TrackTime  
	// creating annotation to use it in commonPointConfig from there it will be used in PerformacheTrackingAspect for ...
	public int calculateMax() {
		int[] data = dataService.retrieveData();
//		throw new RuntimeException("Something went wrong");
		return Arrays.stream(data).max().orElse(0);
	}
}
