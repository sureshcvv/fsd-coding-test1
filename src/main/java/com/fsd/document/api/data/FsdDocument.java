package com.fsd.document.api.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class FsdDocument {

	@Id
	private String documentId;
	private String documentName;
	private String uploadedUser;
	private String uploadedDate;
	private String document;
}
