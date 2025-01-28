package ru.vasilev.license.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.vasilev.license.model.License;
import ru.vasilev.license.service.LicenseService;

@RestController
@RequestMapping("/v1/organization/{organizationId}/license")
public class LicenseController {
	private final LicenseService licenseService;
	
	public LicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }
	
	@GetMapping("/{licenseId}")
	public ResponseEntity<License> getLicense(
			@PathVariable("organizationId") String organizationId,
			@PathVariable("licenseId") String licenseId
			){
		License license = licenseService.getLicense(licenseId, organizationId); 
		return ResponseEntity.ok(license);
	}
	
	@PostMapping
	public ResponseEntity<String> createLicense(
            @PathVariable("organizationId") String organizationId,
            @RequestBody License request
            ){
		return ResponseEntity.ok(licenseService.createLicense(request, organizationId));
	}
	
	@PutMapping
	public ResponseEntity<String> updateLicense(
			@PathVariable("organizationId") String organizationId,
			@RequestBody License request
            ){
		return ResponseEntity.ok(licenseService.updateLicense(request, organizationId));
	}
	
	@DeleteMapping("/{licenseId}")
	public ResponseEntity<String> deleteLicense(
            @PathVariable("organizationId") String organizationId,
            @PathVariable("licenseId") String licenseId){
		return ResponseEntity.ok(licenseService.deleteLicense(licenseId, organizationId));
	}
        ;
}