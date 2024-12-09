package com.dhiraj.learn_spring_aop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {
	public int[] retrieveData() {
		
		try {
			Thread.sleep(30);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		return new int[] {22, 89, 45, 20, -04, 4353};
	}
}
