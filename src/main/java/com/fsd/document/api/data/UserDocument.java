package com.fsd.document.api.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class UserDocument {

	@Id
	private String userId;
	private String password;
	private String firstName;
	private String lastName;
	
}
