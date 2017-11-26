package com.coderesolutions.htmlextractor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.coderesolutions.htmlextractor.model.ScrappedData;

public interface ScrappedDataRepository extends MongoRepository<ScrappedData, String> {

}
