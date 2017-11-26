package com.coderesolutions.htmlextractor.schedular;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScrappedDataSchedular {
	
	@Scheduled(fixedDelay = 10000)
	public void schedular() {
		
		System.out.println(new Date());
		
	}

}
