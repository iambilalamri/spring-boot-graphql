package com.amrib.graphql.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@PostMapping()
	public void getAllBooks(@RequestBody String query) {

	}
}
