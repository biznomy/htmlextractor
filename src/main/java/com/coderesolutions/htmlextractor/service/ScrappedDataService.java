package com.coderesolutions.htmlextractor.service;

import java.util.List;

import com.coderesolutions.htmlextractor.model.ScrappedData;

public interface ScrappedDataService {
	
	List<ScrappedData> findByFirstStage();

}
