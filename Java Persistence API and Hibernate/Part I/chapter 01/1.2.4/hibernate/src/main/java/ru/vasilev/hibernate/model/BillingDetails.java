package ru.vasilev.hibernate.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingDetails {
	private String account;
	private String bankname;
	private Set<User> users;
}