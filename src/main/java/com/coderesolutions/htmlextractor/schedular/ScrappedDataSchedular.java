package com.coderesolutions.htmlextractor.schedular;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.coderesolutions.htmlextractor.service.ScrappedDataService;

@Component
public class ScrappedDataSchedular {
	
	@Autowired
	ScrappedDataService scrappedDataService; 
	
	@Scheduled(initialDelay = 5000, fixedDelay = 40000)
	public void schedularOne() {
		System.out.println(new Date());
		System.out.println("zero");
		scrappedDataService.findByZeroStage();
	}
	
	@Scheduled(initialDelay = 10000, fixedDelay = 40000)
	public void schedularSecond() {
		System.out.println(new Date());
		System.out.println("first");
		scrappedDataService.findByFirstStage();
	}
	
	@Scheduled(initialDelay = 20000, fixedDelay = 40000)
	public void schedularThird() {
		System.out.println(new Date());
		System.out.println("second");
		scrappedDataService.findBySecondStage();
	}

}
