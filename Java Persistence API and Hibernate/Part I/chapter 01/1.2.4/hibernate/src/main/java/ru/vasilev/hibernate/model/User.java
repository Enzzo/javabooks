package ru.vasilev.hibernate.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	private String username;
	private String addressStreet;
	private String addressZipcode;
	private String addressCity;
	private Set<BillingDetails> billingDetails;
}