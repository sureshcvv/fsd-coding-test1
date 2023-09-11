package com.fsd.document.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fsd.document.api.data.FsdDocument;

@Repository
public interface FsdDocumentRepository extends CrudRepository<FsdDocument, String> {

}
