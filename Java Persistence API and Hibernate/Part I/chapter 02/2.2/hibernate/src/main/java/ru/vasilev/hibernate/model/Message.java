package ru.vasilev.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Message {
	@Id
	@GeneratedValue
	private Long id;
	
	private String text;
	
}