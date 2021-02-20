package com.amrib.graphql.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
	@Id
	private String isn;
	private String title;
	private String publisher;
	private String[] authors;
	private String publishedDate;
}
