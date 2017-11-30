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
	
	@Scheduled(fixedDelay = 1000)
	public void schedularOne() {
		System.err.println("zero : "+ new Date());		
		scrappedDataService.findByZeroStage();
	}
	
//	@Scheduled(fixedDelay = 40000)
//	public void schedularSecond() {
//		scrappedDataService.findByFirstStage();
//	}
//	
//	@Scheduled(fixedDelay = 40000)
//	public void schedularThird() {
//		scrappedDataService.findBySecondStage();
//	}

}
