package ru.vasilev.license.model;

import java.util.Random;

public class LicenseFactory {
	private static LicenseFactory instance = null;
	
	private LicenseFactory() {}
	
	public static LicenseFactory getInstance() {
		if (instance == null) {
			instance = new LicenseFactory();
		}
		return instance;
    }
	
	public License createLicense(String licenseId) {		
		License license = new License();
		license.setId(new Random().nextInt(1000));
		license.setLicenseId(licenseId);
		license.setOrganizationId(null);
		license.setDescription("Software Product");
		license.setProductName("Ostock");
		license.setLicenseType("full");
		
		return license;
    }
}