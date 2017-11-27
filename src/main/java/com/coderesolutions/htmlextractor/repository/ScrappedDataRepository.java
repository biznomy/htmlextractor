package com.coderesolutions.htmlextractor.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.coderesolutions.htmlextractor.model.ScrappedData;

public interface ScrappedDataRepository extends MongoRepository<ScrappedData, String> {
	
	@Query("{ 'zeroStage' : ?0 }")	
	Page<ScrappedData> findByZeroStage(Pageable pageable, boolean zeroStage);
	
	@Query("{ 'firstStage' : ?0 }")	
	Page<ScrappedData> findByFirstStage(Pageable pageable, boolean firstStage);
	
	@Query("{ 'secondStage' : ?0 }")	
	Page<ScrappedData> findBySecondStage(Pageable pageable, boolean secondStage);
	
	

}
