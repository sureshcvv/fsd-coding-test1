package com.fsd.document.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.fsd.document.api.data.UserDocument;

public interface UserRepository extends CrudRepository<UserDocument, String> {

}
