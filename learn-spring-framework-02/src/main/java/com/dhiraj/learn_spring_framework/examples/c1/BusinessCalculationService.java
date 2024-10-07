package com.dhiraj.learn_spring_framework.examples.c1;

import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class BusinessCalculationService {
    private DataService dataService;

    // autowired
    public BusinessCalculationService(DataService dataService){
        super();
        this.dataService = dataService;
    }

    public int findMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
