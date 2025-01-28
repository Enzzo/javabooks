package ru.vasilev.license.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import ru.vasilev.license.model.License;
import ru.vasilev.license.model.LicenseFactory;

@Service
public class LicenseService {
	public License getLicense(String licenseId, String organizationId) {		
		return LicenseFactory.getInstance().createLicense(licenseId, organizationId);
	}
	
	public String createLicense(License license, String organizationId) {
		String responseMessage = null;
		if(license != null) {
			license.setOrganizationId(organizationId);
			responseMessage = String.format("This is the post and the object is: %s", license.toString());
		}
		return responseMessage;
	}
	
	public String updateLicense(License license, String organizationId) {
		String responseMessage = null;
		if(license != null) {
			responseMessage = String.format("This is the put and the object is: %s", license.toString());
		}
		return responseMessage;
	}
	
	public String deleteLicense(String licenseId, String organizationId){
		String responseMessage = null;
		responseMessage = String.format("This is the delete for licenseId: %s and organizationId: %s", licenseId, organizationId);
		return responseMessage;
	}
}