package com.fsd.document.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.document.api.data.FsdDocument;
import com.fsd.document.api.exception.DNFException;
import com.fsd.document.api.repository.FsdDocumentRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/fsd-doc")
public class DocController {
	
	@Autowired
	private FsdDocumentRepository repo;

	@PostMapping
	public FsdDocument createDoc(@RequestBody FsdDocument doc) {
		return this.repo.save(doc);
	}
	
	@GetMapping
	public List<FsdDocument> getAll() {
		return StreamSupport.stream(this.repo.findAll().spliterator(), false)
			    .collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public FsdDocument getDocument(@PathVariable("id") String documentId) {
		Optional<FsdDocument> opt = this.repo.findById(documentId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new DNFException("Document not found with give documentId" + documentId);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") String documentId) {
		this.repo.deleteById(documentId);
		return "Document is deleted with given documentId" + documentId;
	}
	
}
