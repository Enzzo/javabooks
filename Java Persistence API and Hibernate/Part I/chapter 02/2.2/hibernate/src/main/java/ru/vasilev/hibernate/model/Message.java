package ru.vasilev.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Message {
	@Id
	private Long id;
	
	private String text;
	
}