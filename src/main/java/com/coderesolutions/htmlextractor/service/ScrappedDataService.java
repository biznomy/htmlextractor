package com.coderesolutions.htmlextractor.service;

import com.coderesolutions.htmlextractor.model.ScrappedData;

public interface ScrappedDataService {
	
	void findByZeroStage();
	
	void findByFirstStage();
	
	void findBySecondStage();
	
	ScrappedData saveScrappedData(ScrappedData scrappedData);

}
