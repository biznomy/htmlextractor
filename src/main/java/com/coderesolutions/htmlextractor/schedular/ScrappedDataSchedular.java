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
	
//	@Scheduled(fixedDelay = 1000000)
	public void schedularOne() {
		System.out.println(new Date());
		scrappedDataService.findByFirstStage();
	}
	
	@Scheduled(fixedDelay = 1000000)
	public void schedularSecond() {
		System.out.println(new Date());		
	}
	
	@Scheduled(fixedDelay = 1000000)
	public void schedularThird() {
		System.out.println(new Date());		
	}

}
